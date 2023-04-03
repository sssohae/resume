package co.yedam.silhyun.member.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.yedam.silhyun.SessionUser;
import co.yedam.silhyun.member.vo.MemberVO;
import co.yedam.silhyun.member.vo.UserVO;

@Service
public class UsersService implements UserDetailsService {
	
	@Autowired MemberService mService;
	
	@Autowired HttpSession httpSession;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVO vo = new MemberVO();
		vo.setId(username);
		vo = mService.memeberSelect(vo);
		
		//사용자가 존재하지 않을때
		if(vo == null) {
			throw new UsernameNotFoundException("no user");
		}
		UserVO uvo = new UserVO();
		uvo.setId(vo.getId());
		uvo.setMemCd(vo.getMemCd());
		uvo.setPwd(vo.getPwd());
		
		//httpSession.setAttribute("user", new SessionUser(uvo));
		
		return uvo;
	}

}
