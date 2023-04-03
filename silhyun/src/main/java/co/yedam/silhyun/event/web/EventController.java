package co.yedam.silhyun.event.web;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.yedam.silhyun.event.service.EventService;
import co.yedam.silhyun.mypage.vo.ChulcheckVO;
import co.yedam.silhyun.mypage.vo.PointVO;

@Controller
public class EventController {

	@Autowired
	private EventService eventService;

	@RequestMapping("/silhyun/eventPage")
	public String eventPage(Model model) {
		model.addAttribute("eventPage", eventService.getEventList());
		model.addAttribute("bannerList", eventService.getBannerList());
		return "event/eventPage";
	}

	@GetMapping("/silhyun/siteIntroduce")
	public String siteIntroduce() {

		return "event/siteIntroduce";
	}

	@GetMapping("/eventForm")
	public String eventForm() {

		return "event/eventForm";
	}

	//출첵이벤트
	@PostMapping("/chulcheckEv")
	@ResponseBody
	public boolean chulcheckEv(HttpSession session, @DateTimeFormat(pattern = "yyyy-MM-dd") Date checkDate) {
	  String id = (String)session.getAttribute("id");
	  
	  //오늘 출결확인
	  List<ChulcheckVO> rvo = eventService.recentlyDate(id);
	  if(rvo.size()!=0) {	
		  Date date = rvo.get(0).getCheckDate();	//그 id의 젤 최근 출석날짜
	    if (checkDate.equals(date)) {		//오늘 지역 날짜 == db에 있는 날짜
	      return false;
	    }
	  }
	  //정보조회 안됐을 때 insert
	  ChulcheckVO vo = new ChulcheckVO();
	  //PointVO pvo = new PointVO();
	  vo.setId(id);
	  //pvo.setId(vo.getId());
	  vo.setCheckDate(checkDate);	//날짜 넣기
	//  pvo.setSaveDate(vo.getCheckDate());
	  eventService.insertChulcheck(vo);
	  //eventService.updatePointChul(pvo);
	  	 
	  return true;
	}



	//출첵페이지
	@RequestMapping("/silhyun/chulcheck")
	public String chulchecck(Model model,HttpSession session) {
		String id = (String)session.getAttribute("id");
		//local Date생성
		LocalDateTime now = LocalDateTime.now(); // 현재 시간 정보를 가진 LocalDateTime 객체
		
		//localDate=> date 변환
		ZoneId zone = ZoneId.systemDefault(); // 현재 시스템 시간대 정보를 가진 ZoneId 객체		
		Date date = Date.from(now.atZone(zone).toInstant()); // Date 객체로 변환

		// Date 객체를 String 형식으로 변환
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = dateFormat.format(date);
		
		model.addAttribute("date", dateString);
		
		
		return "event/chulcheck";
	}

}
