package co.yedam.silhyun;

import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.yedam.silhyun.common.service.MainService;
import co.yedam.silhyun.common.vo.ReviewVO;
import co.yedam.silhyun.event.vo.EventVO;
import co.yedam.silhyun.member.vo.FieldVO;
import co.yedam.silhyun.member.vo.PhotographerVO;
import co.yedam.silhyun.portfolio.vo.PortfolioVO;

@Controller
public class MainController {
	@Autowired MainService mainService;

	@GetMapping("/")
	public String layoutTest(HttpSession session, Model model,PhotographerVO vo, PortfolioVO pvo,EventVO evo,ReviewVO rvo,FieldVO fvo) {
		model.addAttribute("id", session.getAttribute("id")); //세션
		model.addAttribute("hotList",mainService.getHotPtg(vo));  //인기 작가
		model.addAttribute("newList",mainService.getNewPtg(vo));  //최신 작가
		model.addAttribute("portList",mainService.getPtgPortfolioList(pvo));// 작가 포트폴리오 랜덤 출력
		model.addAttribute("eventList",mainService.getEventList(evo)); //이벤트 배너 가진 출력
		model.addAttribute("revList",mainService.getReviewA(rvo)); //작가 리뷰 최신순 
		model.addAttribute("clasList",mainService.getReviewC(rvo)); //클래스 리뷰 최신순 
		model.addAttribute("bestList",mainService.getReview(rvo)); //리뷰 별점 5점(작가+클래스) 
		model.addAttribute("fldList",mainService.getFeildList(fvo)); //field테이블에 등록된 분야로 태그 동적 생성
		return "home/home";
	}
	
	//▶태그 클릭하면 이동하는 페이지
	@RequestMapping("/silhyun/ptgTag/{fdCd}")
	public String ptgTag(Model model,@PathVariable String fdCd,FieldVO fvo) {
		model.addAttribute("tagPtgList",mainService.getTagPtgList(fdCd));
		return "home/ptgTag";
	}
	
	//▶작가 사진 클릭시 포트폴리오 띄우기
	@RequestMapping("/ajaxPort/{ptgId}")
	@ResponseBody
	public List<PhotographerVO> ajaxPort(@PathVariable String ptgId){
		return mainService.getPtgPort(ptgId);
	}
}
