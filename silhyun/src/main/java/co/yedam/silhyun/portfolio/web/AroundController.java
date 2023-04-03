package co.yedam.silhyun.portfolio.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.yedam.silhyun.portfolio.service.AroundService;
import co.yedam.silhyun.portfolio.vo.PortfolioVO;
import co.yedam.silhyun.portfolio.vo.TagVO;

@Controller
public class AroundController {

	@Autowired
	private AroundService aroundService;

	@RequestMapping("/silhyun/around")
	public String around(Model model) {
		model.addAttribute("portfolioList", aroundService.getAroundList());
		return "portfolio/around";
	}

	// @ResponseBody 제이슨 객체로 받아올라면 ~ 이거 꼭 써야햇....
	@RequestMapping("/silhyun/aroundTagList")
	@ResponseBody
	public List<PortfolioVO> aroundTagList(PortfolioVO tagCntn) {

		return aroundService.aroundTagList(tagCntn);
	}

	@RequestMapping("/silhyun/tagList") // 태그리스트 가져오기..
	@ResponseBody
	public List<TagVO> tagList(Model model) {
		return aroundService.tagList();
	}

	// 태그 ul만들기
	@RequestMapping(value = "/silhyun/searchTags", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Map<String, Object> searchTags(@RequestParam(value = "tag") String tag) {
		List<String> tags = aroundService.searchTags(tag);
		Map<String, Object> result = new HashMap<>();
		result.put("tags", tags);
		return result;
	}
}
