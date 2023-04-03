package co.yedam.silhyun.member.web;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.yedam.silhyun.event.vo.EventVO;
import co.yedam.silhyun.member.service.AdminSercive;
import co.yedam.silhyun.member.vo.AdminCriteria;
import co.yedam.silhyun.member.vo.AdminPageVO;
import co.yedam.silhyun.member.vo.MemberVO;
import co.yedam.silhyun.member.vo.PhotographerVO;
import co.yedam.silhyun.mypage.vo.QuitVO;

@Controller
public class AdminController {
		
	@Autowired
	private AdminSercive adminService;
	
	
	/*
	 * 작성자: 박소혜
	 * 작성일자: 20230323
	 * 작성내용: 코드 정리중 
	 */
	   

	//대쉬보드========================================
	@GetMapping("/admin/dashBoard")
	public String dashBoard(Model model) {
		model.addAttribute("com", adminService.recentCom());
		model.addAttribute("join", adminService.recentJoin());
		model.addAttribute("buy", adminService.recentBuy());
		model.addAttribute("cfm", adminService.cfmCnt());
		model.addAttribute("lastS", adminService.lastSales());

			List<Map<String,String>> PGraph = adminService.ptgGraph();
			model.addAttribute("PGraph",PGraph);
			
			model.addAttribute("ptgRank", adminService.ptgRank());
			model.addAttribute("classRank", adminService.classRank());
			
			System.out.println(model);
		return "admin/dashBoard";
	}
	
	
	//이벤트관리페이지========================================
	@GetMapping("/admin/eventManage")
	public String eventManage(Model model, AdminCriteria cri) {
		//종료제외 이벤트리스트
		List<Map<String,Object>> eList = adminService.getEventList();
		model.addAttribute("eList", eList);
		
		//종료포함 이벤트리스트
		List<Map<String,Object>> eAList = adminService.getEventAllList();
		model.addAttribute("eAList", eAList);

		//이벤트 count
		model.addAttribute("eCnt", adminService.getEventCnt());
		
		return "admin/eventManage";
	}
	
	
	//종합승인페이지========================================
	@GetMapping("/admin/memberAccept")
	public String memberAccept(String ptgId, Model model) {
		
		model.addAttribute("needCfm", adminService.countNeedCfm());
		
		model.addAttribute("ptgList", adminService.ptgCfmList());
		
		model.addAttribute("stdList", adminService.stdCfmList());
		
		model.addAttribute("classList", adminService.classCfmList());
		
		List<Map<String,Object>> eList = adminService.getEventOList();
		model.addAttribute("eList", eList);

		
		System.out.println(model);
		
		return "admin/memberAccept";
	}
	
	
	//이벤트 상세정보 아작스 
	@RequestMapping("/admin/eventManageSelect")
	@ResponseBody
	public EventVO eventManageSelect(@RequestParam("eventNum") String eventNum) {
	    return adminService.getEventContent(eventNum);
	}
	

	
	//기록가 승인요청 상세정보
	@RequestMapping("/admin/ptgSelect")
	@ResponseBody
	public Map<String, Object> ptgSelect(@RequestParam("ptgId") String ptgId){
		return adminService.ptgSelect(ptgId);
	}
	
	//기록가 승인요청 승인
	@RequestMapping("/admin/ptgAccept")
	@ResponseBody
	public String ptgAccept(@RequestParam("ptgId") String ptgId){
		 String msg="";
		 int n;
		 
		 n = adminService.ptgAccept(ptgId);
		
		 if (n!=0) {
			 msg = ptgId+"님을 승인 완료했습니다.";
		 }else {
			 msg ="승인 실패";
		 }

		 return msg;
	}
	
	//기록가 승인요청 반려
	@RequestMapping("/admin/noAccept")
	@ResponseBody
	public String noPtgAccept(@RequestParam("ptgId") String ptgId){
		 String msg="";
		 int n;
		 
		 n = adminService.noPtgAccept(ptgId);
		
		 if (n!=0) {
			 msg = ptgId+"님을 승인 반려했습니다.";
		 }else {
			 msg ="반려 실패";
		 }

		 return msg;
	}
	
	
	//사진관 승인요청 상세정보
	@RequestMapping("/admin/stdSelect")
	@ResponseBody
	public Map<String, Object> stdSelect(@RequestParam("stId") String stId){
		return adminService.stdSelect(stId);
	}
	
	//사진관 승인요청 승인
	@RequestMapping("admin/stdAccept")
	@ResponseBody
	public String stdAccept(@RequestParam("stId") String stId){
		 String msg="";
		 int n;
		 
		 n = adminService.stdAccept(stId);
		
		 if (n!=0) {
			 msg = stId+"님을 승인 완료했습니다.";
		 }else {
			 msg ="승인 실패";
		 }
		 
		 return msg;
	}
	
	//사진관 승인요청 반려
	@RequestMapping("admin/noStdAccept")
	@ResponseBody
	public String noStdAccept(@RequestParam("stId") String stId){
		 String msg="";
		 int n;
		 
		 n = adminService.noStdAccept(stId);
		
		 if (n!=0) {
			 msg = stId+"님을 승인 반려했습니다.";
		 }else {
			 msg ="반려 실패";
		 }
		 
		 return msg;
	}
	
	//클래스 승인요청 상세정보
	@RequestMapping("/admin/classSelect")
	@ResponseBody
	public Map<String, Object> classSelect(@RequestParam("classNum") String classNum){
		return adminService.classSelect(classNum);
	}
	
	//클래스 승인요청 승인
	@RequestMapping("/admin/classAccept")
	@ResponseBody
	public String classAccept(@RequestParam("classNum") String classNum){
		 String msg="";
		 int n;
		 
		 n = adminService.classAccept(classNum);
		
		 if (n!=0) {
			 msg = "승인완료했습니다.";
		 }else {
			 msg ="승인 실패";
		 }

		 return msg;
	}
	
	//클래스 승인요청 반려
	@RequestMapping("/admin/noClassAccept")
	@ResponseBody
	public String noClassAccept(@RequestParam("classNum") String classNum){
		 String msg="";
		 int n;
		 
		 n = adminService.noClassAccept(classNum);
		
		 if (n!=0) {
			 msg = "승인 반려했습니다.";
		 }else {
			 msg ="반려 실패";
		 }

		 return msg;
	}
	
	
	//event 승인요청 승인
	@RequestMapping("/admin/eventAccept")
	@ResponseBody
	public String eventAccept(@RequestParam("eventNum") String eventNum){
		 String msg="";
		 int n;
		 
		 n = adminService.eventAccept(eventNum);
		
		 if (n!=0) {
			 msg = "승인 완료했습니다.";
		 }else {
			 msg ="승인 실패";
		 }

		 return msg;
	}
	
	//event 승인요청 반려
	@RequestMapping("/admin/noEventAccept")
	@ResponseBody
	public String noEventAccept(@RequestParam("eventNum") String eventNum){
		 String msg="";
		 int n;
		 
		 n = adminService.noEventAccept(eventNum);
		
		 if (n!=0) {
			 msg = "이벤트를 승인 반려했습니다.";
		 }else {
			 msg ="반려 실패";
		 }

		 return msg;
	}
	
	

	//회원관리페이지========================================
	@RequestMapping("/admin/memberManage")
	public String memberManage(@ModelAttribute("cri") AdminCriteria cri, @ModelAttribute("cri2") AdminCriteria cri2, 
			@ModelAttribute("cri3") AdminCriteria cri3, MemberVO vo, Model model, 
			@RequestParam(value = "pageNum2", required = false, defaultValue = "1") int pageNum2,
			@RequestParam(value = "keyword2", required = false) String keyword2,
			@RequestParam(value = "pageNum3", required = false, defaultValue = "1") int pageNum3,
			@RequestParam(value = "keyword3", required = false) String keyword3) {
		
		cri2.setPageNum(pageNum2);
		cri2.setKeyword(keyword2);
		cri3.setPageNum(pageNum3);
		cri3.setKeyword(keyword3);
		
		model.addAttribute("todayMem", adminService.todayMem());
		model.addAttribute("todayPtg", adminService.todayPtg());
		model.addAttribute("todayStd", adminService.todayStd());
		
		model.addAttribute("memberList", adminService.memberList());
		model.addAttribute("ptgList",adminService.ptgList());
		model.addAttribute("stdList",adminService.stdList());	
		
		
		//회원전체리스트 페이징 
		cri.setAmount(5);
		model.addAttribute("list", adminService.getListMember(cri));
		model.addAttribute("page", new AdminPageVO(adminService.getTotalCount(cri), 10, cri));
		
		//작가리스트 페이징
		cri2.setAmount(5);
		model.addAttribute("ptglist", adminService.getListPtg(cri2));
		model.addAttribute("ptgPage", new AdminPageVO(adminService.getTotalPtg(cri2), 10, cri2));
		
		//작가리스트 페이징
		cri3.setAmount(5);
		model.addAttribute("stdList", adminService.getListStd(cri3));
		model.addAttribute("stdPage", new AdminPageVO(adminService.getTotalStd(cri3), 10, cri3));

		return "admin/memberManage";
	}
	
	//사진관 소속작가확인 아작스
	@RequestMapping("/belongPtg")
	@ResponseBody
	public Map<String,Object> belongPtg(String stId) {
	
		Map<String, Object> map = new HashMap<String, Object>();
		List<PhotographerVO> list = adminService.belongPtg(stId);
		
		map.put("belongPtg", list);
		map.put("result", "success");
		map.put("STbelong", stId);

		return map;
	}
	
	//회원 정보수정
	@PostMapping("/updateMember")
	public String updateMember(MemberVO vo) {	
		int n = adminService.updateMember(vo); 
		
		if(n!=0) {
			System.out.println("회원정보 수정성공");
		}else {
			System.out.println("회원정보 수정실패");
		}
		return "redirect:admin/memberManage";
	}
	
	//멤버 비활성화 단건
	@RequestMapping("/disableMember")
	public String disableMember(String id) {	
		int n = adminService.disableMember(id);

		if(n !=0) {
			System.out.println(id+"비활성화완료");
		}else {
		}
		
		return "redirect:admin/memberManage";
		//test
	}
	
	//멤버 활성화 단건
	@RequestMapping("/ableMember")
	public String ableMember(String id) {
		int n = adminService.ableMember(id);

		if(n !=0) {
			System.out.println(id+"비활성화완료");
		}else {
		}
		
		return "redirect:admin/memberManage";
		//test
	}
	
	
	
	//관리자계정 관리페이지========================================
	//관리자정보 가져오기
	@GetMapping("/admin/adminManage")
	public String adminManage(Model model) {
		model.addAttribute("adminInfo", adminService.adminInfo());
		return "admin/adminManage";
	}
	
	//관리자 정보수정
	@PostMapping("/updateAdmin")
	public String updateAdmin(MemberVO vo) {		
		
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(10);
		String pwd = bcrypt.encode(vo.getPwd());
		vo.setPwd(pwd);
		
		int n = adminService.updateAdmin(vo);

		if(n!=0) {
			System.out.println("수정성공");
			
		}else {
			System.out.println("수정실패");
		}
		return "redirect:admin/adminManage";
	}
	
	

	
	//탈퇴 관리페이지========================================
	@GetMapping("/admin/quitManage")
	public String quitManage(AdminCriteria cri, QuitVO vo, Model model) {
		model.addAttribute("qtList",adminService.qtList());
		
		List<Map<String,String>> list = adminService.quitGraph();
		model.addAttribute("gtGraph",list);
	
		//페이징
		cri.setAmount(5);
		model.addAttribute("list", adminService.getListQuit(cri));
		model.addAttribute("page", new AdminPageVO(adminService.getTotalQuit(cri), 10, cri));

		return "admin/quitManage";
	}


	
}

