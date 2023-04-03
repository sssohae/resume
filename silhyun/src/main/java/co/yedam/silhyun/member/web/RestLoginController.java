package co.yedam.silhyun.member.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import co.yedam.silhyun.member.service.EmailService;
import co.yedam.silhyun.member.service.MemberService;
import co.yedam.silhyun.member.vo.MemberVO;
import co.yedam.silhyun.mypage.service.MypageAoService;
import co.yedam.silhyun.mypage.web.mypageAoController;

@RestController
public class RestLoginController {
	@Autowired MemberService mService;
	@Autowired MypageAoService mAoService;
	@Autowired EmailService emailService;
	
	@PostMapping("/findId")
	public String findId(MemberVO vo) {
		String id = "";
		id = mService.findid(vo);
		return id;
		
	}
	
	@PostMapping("/findPwd")
	public String findPwd(MemberVO vo) {
		String msg = "";
		//pwd여부 int값 체크 
		int i = mService.isPwdChek(vo);
		if(i > 0) {
			//0보다 크면 임시 비번 이메일 발송후 코드 값을 암호화 해서 멤버정보 수정
			String n = "pwdCk";
			String code = emailService.sendSimpleMessage(vo.getEmail(), n);
			
			//임시비번 암호화
			MemberVO mvo = new MemberVO();
			BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(10);
			String result = bcrypt.encode(code);
			vo.setPwd(result);
			//비밀번호를 발송한 임시비밀번호로 변경
			mAoService.ptgInfoUpdate(vo);
			msg ="임시비밀번호가 이메일로 발송되었습니다.";
			
		}else {
			msg ="임시비밀번호 발송이 취소되었습니다.";
		}
		
		
		return msg;
	}

}
