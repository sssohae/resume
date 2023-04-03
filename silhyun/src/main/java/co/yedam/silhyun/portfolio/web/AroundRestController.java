package co.yedam.silhyun.portfolio.web;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.yedam.silhyun.portfolio.service.AroundService;

@RestController

public class AroundRestController {

	@Autowired
	private AroundService aroundService;

	@RequestMapping(value = "/AjaxAroundList", produces = "application/json;charset=UTF-8")
	public String ajaxAroundList(Model model) {
		String str = null;
		ObjectMapper json = new ObjectMapper();
		try {
			str = json.writeValueAsString(aroundService.getAroundList());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println("호출되었니");
		return str;

	}

	@RequestMapping(value = "/sear", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Map<String, Object> searcgs(@RequestParam(value = "tag") String tag) {
		String encodedQuery = null;
		try {
			encodedQuery = URLEncoder.encode(tag, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 인코딩
		List<String> tags = aroundService.searchTags(encodedQuery);
		Map<String, Object> result = new HashMap<>();
		result.put("tags", tags);
		return result;
	}
}
