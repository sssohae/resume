package co.yedam.silhyun.common.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import co.yedam.silhyun.SessionUser;
import co.yedam.silhyun.common.service.PageTestService;
import co.yedam.silhyun.common.vo.Criteria;
import co.yedam.silhyun.common.vo.PageVO;
import co.yedam.silhyun.common.vo.ReviewVO;
import javassist.expr.NewArray;

@Controller
public class CommonController {

	@Autowired PageTestService pService;
	
	@GetMapping("/reviewList")
	public String reviewList(Criteria cri, ReviewVO vo, Model model) {
		cri.setAmount(5);

		model.addAttribute("list", pService.getListReview(cri));
		model.addAttribute("page", new PageVO(pService.getTotalCount(cri), 10, cri));
		return "home/pagingTest";
	}
	
	@GetMapping("/list")
	public String list(Criteria cri, Model model) {
		cri.setAmount(5);
		model.addAttribute("list", pService.getListReview(cri));
		model.addAttribute("page", new PageVO(pService.getTotalCount(cri), 10, cri));
		return "home/ajaxPagingTest";
	}

	@GetMapping("/ajaxList")
	public String ajaxList(Criteria cri, Model model) {
		cri.setAmount(5);
		model.addAttribute("list", pService.getListReview(cri));
		model.addAttribute("page", new PageVO(pService.getTotalCount(cri), 10, cri));
		return "home/pagingTest";
	}
	
	
}
