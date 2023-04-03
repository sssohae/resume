package co.yedam.silhyun.qst.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.yedam.silhyun.common.vo.CommentVO;
import co.yedam.silhyun.qst.service.QstService;
import co.yedam.silhyun.qst.vo.QstVO;

@Controller
public class QstController {

	@Autowired
	private QstService qstService;
	
	@RequestMapping("/qst/aoQst")
	public String aoQst(Model model) {
		model.addAttribute("aoQstList", qstService.getAoQstList());
		return "qst/aoQst";
	}
	
	
	@GetMapping("/getAoQstList")
	@ResponseBody
	public List<QstVO> getAoQstList(QstVO vo, Model model){
		List<QstVO> getAoQstList = qstService.getAoQstList();
		return getAoQstList;
	}
	
	@PostMapping("/aoQstInsert")
	@ResponseBody
	public String aoQstInsert(@RequestBody QstVO vo) {
		
		qstService.aoQstInsert(vo);
		return "seccess";
	}	
	
	@DeleteMapping("/aoQstDelete")
	public String aoQstDelete(QstVO vo) {
		
		qstService.aoQstDelete(vo);
		return "qst/aoQst";
	}
	
	@PostMapping("/aoAnsInsert")
	@ResponseBody
	public String aoAnsInsert(@RequestBody CommentVO cvo,QstVO vo) {
		
		qstService.aoAnsInsert(cvo);
		return "qst/aoQst";
	}
	
	@DeleteMapping("/aoAnsDelete")
	public String aoAnsDelete(CommentVO cvo) {
		
		qstService.aoAnsDelete(cvo);
		return "qst/aoQst";
	}
	
	@PostMapping("/aoQstUpdate") 
	@ResponseBody
	public String aoQstUpdate(@RequestBody QstVO vo) {
		
		qstService.aoQstUpdate(vo);
		return "success";
	}
	
	@PostMapping("/aoAnsUpdate") 
	@ResponseBody
	public String aoAnsUpdate(@RequestBody CommentVO cvo, QstVO vo) {
		
		qstService.aoAnsUpdate(cvo);
		return "success";
	}
	
	
	
	
	
	
	
	
	
	
	
}
