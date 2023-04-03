package co.yedam.silhyun.member.service;


import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.nimbusds.oauth2.sdk.AuthorizationCode;

import co.yedam.silhyun.OAuthAttributes;
import co.yedam.silhyun.SessionUser;
import co.yedam.silhyun.member.vo.MemberVO;
import co.yedam.silhyun.member.vo.UserVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OAuthUserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

	private final MemberService memberService;
	private final HttpSession httpSession;
	
    @Override
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {
        OAuth2UserService<OAuth2UserRequest, OAuth2User> oAuth2UserService = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = oAuth2UserService.loadUser(oAuth2UserRequest);
        
        // 현재 진행중인 서비스를 구분('naver', 'kakao')
        String registrationId = oAuth2UserRequest.getClientRegistration().getRegistrationId();

        // OAuth2 로그인 시 키 값(네이버 "response", 카카오는 "id")
        String userNameAttributeName = oAuth2UserRequest.getClientRegistration()
        		.getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();

	    //로그인을 통해 가져온 OAuth2User의 attribute 담기
        OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());
   
        //로그인 정보를 db저장/시큐리티 vo에 담기
		UserVO user = saveOrUpdate(attributes);
		
		//세션보에 담기
		httpSession.setAttribute("id", attributes.getId());
		httpSession.setAttribute("role", Collections.singleton(new SimpleGrantedAuthority(user.getMemCd())));
		
		
        return new DefaultOAuth2User(Collections.singleton(new SimpleGrantedAuthority(user.getMemCd()))
                , attributes.getAttributes()
                , attributes.getNameAttributeKey());
	}
	
    private UserVO saveOrUpdate(OAuthAttributes attributes) {
    	//보에 담아서 인써트
        MemberVO vo = new MemberVO();
        vo.setId(attributes.getId());
        vo.setPwd(attributes.getPwd());
        vo.setName(attributes.getName());
        vo.setTel(attributes.getTel());
        vo.setBirthDate(attributes.getBirthDate());
        vo.setGenCd(attributes.getGenCd());
        vo.setLoginCd(attributes.getLoginCd());
        vo.setToken(attributes.getToken());
        vo.setEmail(attributes.getEmail());
        vo.setProfile(attributes.getProfile());
        
        MemberVO mvo = new MemberVO();
		UserVO uvo = new UserVO();
		mvo = memberService.memeberSelect(vo);
		if(mvo == null) {
			memberService.memberInsert(vo);
			vo = memberService.memeberSelect(vo);
			uvo.setId(vo.getId());
			uvo.setMemCd(vo.getMemCd());
			uvo.setPwd(vo.getPwd());
		}else {
			//디비에 값이있음 uvo에만 담아준다.
			uvo.setId(mvo.getId());
			uvo.setMemCd(mvo.getMemCd());
			uvo.setPwd(mvo.getPwd());
		}

        return uvo;
    }

}
