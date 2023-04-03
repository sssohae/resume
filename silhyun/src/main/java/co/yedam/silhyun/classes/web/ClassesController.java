package co.yedam.silhyun.classes.web;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.yedam.silhyun.classes.service.ClassesService;
import co.yedam.silhyun.classes.vo.InetClassesWtchVO;

@Controller
public class ClassesController {

	@Autowired
	private ClassesService ClassesService;
	
	//클래스 메인페이지
	@RequestMapping("/classes/classesMain")
	public String classesMain(Model model) {	
		model.addAttribute("c1List", ClassesService.getC1List());
		model.addAttribute("c2List", ClassesService.getC2List());
		
		return "classes/classesMain";
	}
	
     
    //메인페이지에서 분야클릭시 클래스리스트 바꾸는 아작스
    @RequestMapping(value = "/silhyun/classes/cdtCList")
    public @ResponseBody Map<String, Object> cdtCList(@RequestParam("param1") int param1) {   	
        List<Map<String, Object>> cdtC1List = ClassesService.cdtC1List(param1);
        List<Map<String, Object>> cdtC2List = ClassesService.cdtC2List(param1);

        Map<String, Object> result = new HashMap<>();
        
        result.put("cdtC1List", cdtC1List);
        result.put("cdtC2List", cdtC2List);

        return result;
    }

	
	//클래스 상세정보
	@RequestMapping("/silhyun/classes/classesInfo")
	public String classesInfo(String classNum, Model model, HttpSession httpSession) {
	    String id = (String)httpSession.getAttribute("id");

	    //클래스 개별정보
	    model.addAttribute("cInfo", ClassesService.selectClass(classNum));
	    model.addAttribute("plusInfo", ClassesService.CPlusInfo(classNum));
	    model.addAttribute("randomList", ClassesService.randomList(classNum));	
	    
	    //회원정보를 필요로 하는 부분 체크 
	    if (id != null) {
	    	
	        model.addAttribute("cmPlusInfo", ClassesService.CMPlusInfo(classNum, id));
	    }

	    return "classes/classesInfo";
	}

	
	//인강 비디오 페이지
	@RequestMapping("/silhyun/classes/classesVideo")
	public String classesVideo(Model model, @RequestParam("inetNum") String inetNum, @RequestParam("classNum") String classNum, HttpSession httpSession) {
		String id = (String)httpSession.getAttribute("id");		
		
	    model.addAttribute("IV", ClassesService.selectIV(classNum, inetNum, id));
	    model.addAttribute("id",id);
	    
	    return "classes/classesVideo";
	}
	
	
	//내가 수강중인 클래스 페이지
	@GetMapping("/silhyun/myPage/myClasses")
	public String myClasses(Model model, HttpSession httpSession) {	
	    String id = (String)httpSession.getAttribute("id");
	    
		model.addAttribute("myName",ClassesService.getName(id));
		model.addAttribute("myC1", ClassesService.myTakeC1(id));
		model.addAttribute("myC2", ClassesService.myTakeC2(id));
		
		int count1 = ClassesService.myTakeC1(id).size();

		int count2 = ClassesService.myTakeC2(id).size();
		
		model.addAttribute("count1",count1);
		model.addAttribute("count2",count2);
		
		return "classes/myClasses";
	}
	
	
	//내가 수강중인 클래스 페이지에서 현강 상세정보를 부르는 아작스 
	@RequestMapping("/myPageU/myC1Ajax")
	@ResponseBody
	public Map<String, Object> myC1Ajax(@RequestParam("classNum")String classNum, Model model) {
		model.addAttribute("myClAjax", ClassesService.myC1Ajax(classNum));

		return ClassesService.myC1Ajax(classNum);
	}
	
	
	//내가 수강한 인강의 비디오목록 페이지 
	@RequestMapping("/silhyun/classes/myClassesVideos")
	public String myClassesVidios(@RequestParam("classNum") String classNum, Model model, HttpSession httpSession) {  
		String id = (String)httpSession.getAttribute("id");

		model.addAttribute("IVInfo",ClassesService.getClassIVInfo(id, classNum));
		
		return "classes/myClassesVideos";	
	}
	
	
	//베스트 클래스
	@GetMapping("/bestClasses")
	public String bestClasses(Model model) {	
		model.addAttribute("bCList", ClassesService.getBCList());
		
		return "classes/bestClasses";
	}
	
	
	//무료 클래스
	@GetMapping("/freeClasses")
	public String freeClasses(Model model) {	
		model.addAttribute("fCList", ClassesService.getFCList());

		return "classes/freeClasses";
	}

	
	//인강 비디오에서 시청기록 삽입
    @ResponseBody
    @RequestMapping(value = "/silhyun/classes/insertWInfo", method = RequestMethod.POST)
    public InetClassesWtchVO insertWInfo(InetClassesWtchVO vo) {
		int n = ClassesService.insertWInfo(vo);
		
		if (n != 0) {
			System.out.println("시청기록 갱신완료");
		}else {
			System.out.println("시청기록 갱신실패");
		}
        
        return vo;
        
    }

    
    
}
