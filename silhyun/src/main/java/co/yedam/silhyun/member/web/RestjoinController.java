package co.yedam.silhyun.member.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import co.yedam.silhyun.member.service.EmailService;
import co.yedam.silhyun.member.service.MemberService;
import co.yedam.silhyun.member.vo.MemberVO;

@RestController
public class RestjoinController {
	@Autowired MemberService memberService;
	@Autowired EmailService emailService;
	
	@PostMapping("/silhyun/idCk")
	public boolean idCk(MemberVO vo) {
		//나중에 탈퇴회원 중복 확인도 넣기 여기서 구별해서 값 보내기
		//리턴값을 불린에서 int로 변경
		return memberService.isidCheck(vo);
	}
	
	@GetMapping("/silhyun/emailCk")
	public String emailCk(String email){
		String n = "join";
		String code = emailService.sendSimpleMessage(email, n);
		
		return code;
	}
}
