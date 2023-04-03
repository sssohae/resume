package co.yedam.silhyun.mypage.web;

import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import co.yedam.silhyun.classes.vo.ClassesVO;
import co.yedam.silhyun.common.vo.Criteria;
import co.yedam.silhyun.common.vo.PageVO;
import co.yedam.silhyun.event.vo.CouponVO;
import co.yedam.silhyun.event.vo.EventVO;
import co.yedam.silhyun.member.service.MemberService;
import co.yedam.silhyun.member.vo.MemberVO;
import co.yedam.silhyun.member.vo.OptionsVO;
import co.yedam.silhyun.member.vo.PhotographerVO;
import co.yedam.silhyun.member.vo.ReserTimeVO;
import co.yedam.silhyun.mypage.service.MypageAoService;
import co.yedam.silhyun.order.vo.ReserVO;


/* 작성자		:
 * 작성일자 	:
 * 작성내용	:
 * 수정자		:
 * 수정일자	:
 * 수정내용 	:
 * 
 * */

@Controller
public class mypageAoController {

	@Value("${silhyun.saveimg}")
	private String saveimg;

	@Autowired
	private MypageAoService mypageAoService;
	@Autowired
	private MemberService memberService;
	
	//마이페이지(작가)
	@RequestMapping("/photo/mypageAo")
	public String mypageAo(Model model, PhotographerVO pvo,  HttpSession session) {
        String id = (String)session.getAttribute("id");
		model.addAttribute("ptgInfo", mypageAoService.getPhotoinfo(id));
		
		return "mypageAo/mypageAo";
	}

	//작가 정보 수정
	@RequestMapping("/photo/modPfAo")
	public String modpfAo(Model model,  HttpSession session) {
		String id = (String)session.getAttribute("id");
		model.addAttribute("ptgInfo", mypageAoService.getPhotoinfo(id));
		model.addAttribute("workDay",mypageAoService.selectWorkDay(id));
		model.addAttribute("resTime", mypageAoService.ptgRestime(id));
		return "mypageAo/modPfAo";
	}
	
	//대표사진 업로드
	@PostMapping("/uploadPhoto")
	@ResponseBody
	public Map<String, Object> uploadPhoto(ReserVO vo, MultipartFile file) {
		Map<String, Object> map = new HashMap<>();

		if (file != null && !file.isEmpty()) {
			String saveImgPath = saveimg + "portfolio";

			String fileName = UUID.randomUUID().toString(); // UUID생성
			fileName = fileName + "_" + file.getOriginalFilename(); // 유니크한 아이디
			File uploadFile = new File(saveImgPath, fileName);
			try {
				file.transferTo(uploadFile); // 파일저장
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			vo.setMainP("/saveImg/portfolio/" + fileName);
			mypageAoService.uploadPhoto(vo); // db에 담음
			map.put("vo", vo);

		}
		return map;
	}
	//예약관리
	@RequestMapping("/photo/resManage")
	public String resManage(Model model, HttpSession session, Criteria cri) {
		String id = (String)session.getAttribute("id");
		cri.setAmount(6);

		model.addAttribute("ptgInfo", mypageAoService.getPhotoinfo(id));
		model.addAttribute("seReslist",mypageAoService.selectReserList(id, cri));
		System.out.println(model+"123123");
		model.addAttribute("page", new PageVO(mypageAoService.getReserList(id), 10, cri));

		return "mypageAo/resManage";
	}
	
	//운영중인 클래스 관리
	@GetMapping("/photo/classManage")
	public String classManage(Model model,HttpSession session, Criteria cri) {
		String id = (String)session.getAttribute("id");
		cri.setAmount(6);
	
		model.addAttribute("ptgInfo", mypageAoService.getPhotoinfo(id));
		model.addAttribute("clManage", mypageAoService.classList(id,cri));
		model.addAttribute("page", new PageVO(mypageAoService.totalClassList(id), 10, cri));
		return "mypageAo/classManage";
	}
	
	//문의사항(x) 
	@GetMapping("/photo/mypageAoAsk")
	public String mypageAoAsk(Model model, HttpSession session) {
		String id = (String)session.getAttribute("id");
		
		model.addAttribute("ptgInfo", mypageAoService.getPhotoinfo(id));

		return "mypageAo/mypageAoAsk";
	}

	//예약스케쥴(캘린더)
	@GetMapping("/photo/resCalendarAo")
	public String resCalendarAo(Model model,HttpSession session) {
		String id = (String)session.getAttribute("id");
		model.addAttribute("ptgInfo", mypageAoService.getPhotoinfo(id));
		model.addAttribute("workDay",mypageAoService.selectWorkDay(id));

		
		return "mypageAo/resCalendarAo";
	}

	//예약스케쥴(캘린더) 시간 선택->예약 정보 나타나기
	@RequestMapping("/ajaxResInfo/{ptgId}/{redate}/{shotTime}")
	@ResponseBody
	public List<PhotographerVO> ajaxResInfo(Model model,
			                               @PathVariable String ptgId,
			                               @PathVariable String redate,
			                               @PathVariable String shotTime){
		return mypageAoService.getResInfo(ptgId, redate, shotTime);
	}
	
	
	//통계X
	@GetMapping("/photo/mypageStatsAo")
	public String mypageStatsAo(Model model ,HttpSession session) {
		String id = (String)session.getAttribute("id");
		
		model.addAttribute("ptgInfo", mypageAoService.getPhotoinfo(id));
		return "mypageAo/mypageStatsAo";
	}
	//신고
	@GetMapping("/photo/reportFormAo")
	public String reportAo(Model model,HttpSession session) {
		String id = (String)session.getAttribute("id");
		
		model.addAttribute("ptgInfo", mypageAoService.getPhotoinfo(id));
		return "mypageAo/reportFormAo";
	}

	// 작가 정보수정
   @PostMapping("/updateMyPg")
   public String updateMyPg(MemberVO vo ,PhotographerVO pvo) {
      vo.setId(pvo.getPtgId());
      mypageAoService.ptgInfoUpdate(vo);
      mypageAoService.updateWorkday(pvo);
      return "redirect:/photo/modPfAo";
   }


	// 작가 예약 시간 정보 수정
	@PostMapping("/upWorkTime")
	@ResponseBody
	public String upWorkTime(@RequestBody List<ReserTimeVO> reserTimeList) {
		// ptg_id 는 null값으로 보냄
		//리스트 속 아이디는 다 같으므로 첫번째거 들고 옴
		String ptgId = reserTimeList.get(0).getPtgId();
		mypageAoService.deleteReserTime(ptgId);
		int n = 0;
	
		//VO 객체를 반복문을 통해 insertReserTime 메서드로 전달
		for (ReserTimeVO vo : reserTimeList) {
			n = mypageAoService.insertReserTime(vo);
		}
		
		if(n>0) {
			return "성공";
			
		}else {			
			return "실패";
		}

	}

	//프사변경
	@PostMapping("/uploadProfileImage")
	@ResponseBody
	public Map<String,Object> uploadProfileImage(MemberVO vo, MultipartFile file){
		System.out.println("프사볼려는 멤버보?" + vo);
		System.out.println("프사 들어오는지 확인" + file);
		Map<String, Object> map = new HashMap<>();
		
		if (file != null && !file.isEmpty()) {
			String saveImgPath = saveimg + "profil";

			String fileName = UUID.randomUUID().toString(); // UUID생성
			fileName = fileName + "_" + file.getOriginalFilename(); // 유니크한 아이디
			File uploadFile = new File(saveImgPath, fileName);
			
			try {
				file.transferTo(uploadFile); // 파일저장
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			vo.setProfile("/saveImg/profil/" + fileName);
			memberService.updateProfileImage(vo);
			map.put("vo", vo);		
		}
		
		return map;
	}

	//이벤트요청
	@PostMapping("/applyEvent")
	@ResponseBody
	public Map<String, Object> applyEvent(EventVO vo, CouponVO cvo, MultipartFile file) {
		Map<String, Object> map = new HashMap<>();

		if (file != null && !file.isEmpty()) {
			String saveImgPath = saveimg + "banner";
			String fileName = UUID.randomUUID().toString(); // UUID생성
			fileName = fileName + "_" + file.getOriginalFilename(); // 유니크한 아이디
			File uploadFile = new File(saveImgPath, fileName);
			// 이벤트번호,쿠폰번호 난수 생성
			StringBuffer key = new StringBuffer();
			Random rnd = new Random();

			for (int i = 0; i < 6; i++) {
				int index = rnd.nextInt(3);
				switch (index) {
				case 0:
					key.append((char) ((rnd.nextInt(26)) + 97));
					break;
				case 1:
					key.append((char) ((rnd.nextInt(26)) + 65));
					break;
				case 2:
					key.append((rnd.nextInt(10)));
					break;
				}
			}

			try {
				file.transferTo(uploadFile); // 파일저장
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			vo.setBnph("/saveImg/banner/" + fileName);
			vo.setEventNum(vo.getId() + key);

			cvo.setEventNum(vo.getEventNum()); // vo에 담긴 eventNum을 들고오기
			cvo.setCpnNum(vo.getEventNum()); // eventNum이랑 값 같게
			cvo.setCtgrNum(vo.getId());
			cvo.setCpnCd("C1");				//개인인지 공통인지 작가는 c1(개인)만
			mypageAoService.applyEvent(vo); // db에 담음
			mypageAoService.applyECoupon(cvo);

			map.put("vo", vo);
			map.put("cvo", cvo);
		}
		return map;
	}
	
	//클래스 요청
	@PostMapping("/applyClass")
	@ResponseBody
	public Map<String, Object> applyEvent(ClassesVO vo, MultipartFile file) {
		Map<String, Object> map = new HashMap<>();

		if (file != null && !file.isEmpty()) {
			String saveImgPath = saveimg + "thum";

			String fileName = UUID.randomUUID().toString(); // UUID생성
			fileName = fileName + "_" + file.getOriginalFilename(); // 유니크한 아이디
			File uploadFile = new File(saveImgPath, fileName);

			try {
				file.transferTo(uploadFile); // 파일저장
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			vo.setThni("/saveImg/thum/" + fileName);
			mypageAoService.applyClass(vo); // db에 담음
			map.put("vo", vo);
		}
		return map;
	}
	
	//옵션 설정
	@PostMapping("/photo/insertOption")
	@ResponseBody
	public String insertOption(@RequestBody List<OptionsVO> options,Model model,HttpSession session) {
		String id = (String)session.getAttribute("id");
	
		// OptionsVO 객체를 반복문을 통해 insertOption 메서드로 전달
		for (OptionsVO vo : options) {
			vo.setPtgId(id);
			mypageAoService.insertOption(vo);
		}

		return "";
	}
	
	//수강자 조회
	@RequestMapping("/silhyun/mypageAo/classInquiry/{classNum}")
	private String classInquiry(@PathVariable("classNum") String classNum, Model model, HttpSession httpSession) {
		model.addAttribute("memInfo",mypageAoService.clMemInfo(classNum));
		return "mypageAo/classInquiry";
	}

}