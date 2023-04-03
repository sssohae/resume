package co.yedam.silhyun.member.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error, 
			@RequestParam(value = "exception", required = false) String exception,
			Model model) {
		model.addAttribute("error", error);
		model.addAttribute("exception", exception);
		return "login/loginForm";
	}
	

	@GetMapping("/fingInfoForm")
	public String findInfoForm() {
		return "login/fingInfoForm";
	}

	@GetMapping("/silhyun/joinEnd")
	public String joinEnd() {
		return "join/joinCompl";
	}
	
	@GetMapping("/login/naver")
	public String loginNaver(String code) {
		System.out.println(code);
		
		return "home/home";
	}
	


}
