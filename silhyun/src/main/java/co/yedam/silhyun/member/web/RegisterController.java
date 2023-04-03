package co.yedam.silhyun.member.web;

import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import co.yedam.silhyun.common.service.PhotoService;
import co.yedam.silhyun.member.service.RegisterService;
import co.yedam.silhyun.member.vo.FieldVO;
import co.yedam.silhyun.member.vo.MemberVO;
import co.yedam.silhyun.member.vo.PhotographerVO;
import co.yedam.silhyun.member.vo.StudioVO;

@Controller
public class RegisterController {
	@Autowired RegisterService registerService;
	@Autowired PhotoService photoService;

	//▶작가등록 폼 
	@RequestMapping("/shin/ptgRegister")  
	public String ptgRegister(Model model, MemberVO vo,HttpSession session) {
		model.addAttribute("id", session.getAttribute("id")); //세션
		String id = (String) session.getAttribute("id");
		model.addAttribute("member", registerService.getMember(id));
		return "home/ptgRegisterForm";
	}

	//▶작가 등록 Ajax
	@PostMapping("/shin/ptgRegiInsert")
	@ResponseBody
	public PhotographerVO ptgRegiInsert(PhotographerVO pvo, List<MultipartFile> files, FieldVO fvo) {
		String ptgId = registerService.ptgRegiInsert(pvo); //photographer 테이블
		String ctgrNum = ptgId;
		
		photoService.ptgRegiInsert(files, ctgrNum, "A"); //photo 테이블 - 작가 포트폴리오 사진 등록
		fvo.setPtgId(pvo.getPtgId());
		registerService.ptgFldRegiInsert(fvo); //field테이블 - 작가 분야 등록
		return pvo;
	}
	
	//▶사진관 등록 폼 
	@RequestMapping("/shin/stdRegister")
	public String stdRegister(Model model,HttpSession session, MemberVO vo) {
		model.addAttribute("id", session.getAttribute("id")); //세션
		String id = (String) session.getAttribute("id");
		model.addAttribute("member",registerService.getMember(id));
		return "home/stdRegisterForm";
	}
	
	//▶사진관 등록 Ajax
	@PostMapping("/shin/stdRegister")
	@ResponseBody
	public String stdRegiste(StudioVO vo,Model model) {
		registerService.stdRegiInsert(vo);
		return "true";
	}
}
