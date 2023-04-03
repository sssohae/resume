package co.yedam.silhyun.member.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import co.yedam.silhyun.event.service.CouponService;
import co.yedam.silhyun.event.vo.CouponHistoryVO;
import co.yedam.silhyun.member.service.MemberService;
import co.yedam.silhyun.member.vo.MemberVO;
import co.yedam.silhyun.member.vo.UserVO;
import co.yedam.silhyun.mypage.service.PointService;
import co.yedam.silhyun.mypage.vo.PointVO;

@Controller
public class joinConrtroller {
	
	@Autowired MemberService mService;
	@Autowired PointService pService;
	@Autowired CouponService cService;
	
	//회원가임 폼으로 이동
    @GetMapping("/silhyun/joinForm")
    public String joinForm() {
    	return "join/joinForm";
    }
    
    //회원가입 완료 폼으로 이동
    @GetMapping("/silhyun/joininsert")
    public String joinCompl(MemberVO vo, HttpServletRequest request,HttpServletResponse response) {
    	//비번암호화
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(10);
		String result = bcrypt.encode(vo.getPwd());
		vo.setPwd(result);
		
    	//인써트
    	mService.memberInsert(vo);
    	//추천인 아이디가 있음 둘다 인써트 
    	if(vo.getRcomr() != "") {
    		MemberVO mvo = new MemberVO();
    		mvo.setId(vo.getRcomr());
    		boolean n = mService.isidCheck(mvo);
    		if(!n) {
    			PointVO pvo = new PointVO();
    			pvo.setSavePo(1000);
    			pvo.setId(vo.getId());
    			pService.pointInsert(pvo);
    			pvo.setId(vo.getRcomr());
    			pService.pointInsert(pvo);
    		}
    	}
		//쿠폰인써트 
		CouponHistoryVO cvo = new CouponHistoryVO();
		cvo.setCpnNum("1");
		cvo.setId(vo.getId());
		cService.insertCoupon(cvo);
				
		
    	return "redirect:/silhyun/joinCompl";
    }
    
    //나중에 지우자 
    @GetMapping("/silhyun/joinCompl")
    public String testCom() {
    	return "join/joinCompl";
    }
	
}
