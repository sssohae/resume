package co.yedam.silhyun.order.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.yedam.silhyun.classes.vo.ClassesVO;
import co.yedam.silhyun.common.vo.Criteria;
import co.yedam.silhyun.common.vo.PageVO;
import co.yedam.silhyun.event.service.CouponService;
import co.yedam.silhyun.event.vo.CouponHistoryVO;
import co.yedam.silhyun.member.service.PtgService;
import co.yedam.silhyun.member.service.StdService;
import co.yedam.silhyun.member.vo.OptionsVO;
import co.yedam.silhyun.member.vo.PhotographerVO;
import co.yedam.silhyun.member.vo.StudioVO;
import co.yedam.silhyun.mypage.service.PointService;
import co.yedam.silhyun.mypage.vo.PointVO;
import co.yedam.silhyun.mypage.vo.UsedPointVO;
import co.yedam.silhyun.order.service.OrderService;
import co.yedam.silhyun.order.service.PaymentService;
import co.yedam.silhyun.order.service.SelectedOpService;
import co.yedam.silhyun.order.vo.PaymentVO;
import co.yedam.silhyun.order.vo.ReserVO;
import co.yedam.silhyun.order.vo.SelectedOpVO;
/*
 * 작성자: 김지은
 */
@Controller
public class ReserController {
	@Autowired PtgService ptgService;
	@Autowired StdService stdService;
	@Autowired OrderService orderService;
	@Autowired PaymentService paymentService;
	@Autowired SelectedOpService selectedOpService;
	@Autowired PointService pointService;
	@Autowired CouponService couponService;

	/// ▶▶ 작가

	// ▶작가 리스트
	@RequestMapping("/silhyun/ptgList")
	public String ptgList(Criteria cri, Model model, PhotographerVO vo) {
		cri.setAmount(6); // 한 페이지에 보여줄 작가 리스트 개수
		model.addAttribute("ptgList", ptgService.getPtgLsit(cri, vo));
		model.addAttribute("page", new PageVO(ptgService.getTotalCount(cri, vo), 10, cri)); // 페이징
		return "reser/ptgList";
	}
	
//  //▶지역, 분야 검색 
//	@RequestMapping("/silhyun/searchPtgList") 
//	@ResponseBody
//	public List<PhotographerVO> searchPthList(@RequestBody PhotographerVO vo,Criteria cri, Model model) {
//		cri.setAmount(6);
//		System.out.println("vo : " + vo);
//		model.addAttribute("list", ptgService.ptgSearchList(cri, vo));
//		model.addAttribute("page", new PageVO(ptgService.getTotalListCount(cri, vo), 10, cri));
//		return ptgService.ptgSearchList(cri,vo);
//	}
//	//▶검색 필터 Ajax
//	@GetMapping("/silhyun/AjaxPtgList/{searchType}")
//	@ResponseBody
//	public List<PhotographerVO> ajaxPtgList(Model model,@PathVariable String searchType, PhotographerVO vo, Criteria cri) {
//		cri.setAmount(6);
//		model.addAttribute("list", ptgService.getPtgLsit(cri, vo));
//		model.addAttribute("page", new PageVO(ptgService.getTotalCount(cri, vo), 10, cri));
//		return ptgService.getPtgLsit(cri, vo);
//	}

	// ▶ 작가 한명 상세페이지
	@GetMapping("/silhyun/ptgDetail/{ptgId}")
	public String ptgDetail(Model model, PhotographerVO vo, @PathVariable String ptgId) {
		model.addAttribute("ptg", ptgService.getPtg(ptgId));
		return "reser/ptgDetail";
	}

	/// ▶▶사진관

	//▶ 사진관 전체 리스트
	@RequestMapping("/silhyun/stdList")
	public String studioList(Criteria cri, Model model, StudioVO vo) {
		cri.setAmount(3);
		model.addAttribute("page", new PageVO(stdService.getTotalCount(cri, vo), 10, cri)); // 페이징
		model.addAttribute("stdList", stdService.getStdList(cri, vo));
		return "reser/stdList";
	}

	//▶ 사진관 상세 보기
	@RequestMapping("/silhyun/stdDetail/{stId}")
	public String stdDetail(Model model, StudioVO vo, @PathVariable String stId) {
		model.addAttribute("std", stdService.getStd(stId));
		return "reser/stdDetail";
	}

	//▶ 사진관 정보 Ajax
	@RequestMapping("/ajaxStdList/{stdId}")
	@ResponseBody
	public List<StudioVO> ajaxStdList(@PathVariable String stdId) {
		return stdService.getReserList(stdId);
	}
	
	///▶예약

	//▶ 선택한 작가 예약하러 가기 (작가)
	@RequestMapping("/pay/reserList/{ptgId}")
	public String reserList(Model model, PhotographerVO vo, @PathVariable String ptgId, HttpSession session) {
		model.addAttribute("id", session.getAttribute("id"));
		model.addAttribute("res", ptgService.getReser(ptgId));
		return "reser/reserList";
	}

	//▶ 작가가 등록한 시간 Ajax (작가)
	@RequestMapping("/ajaxResTime/{ptgId}/{redate}")
	@ResponseBody
	public List<PhotographerVO> ajaxResTime(Model model, 
			                                @PathVariable String redate, 
			                                @PathVariable String ptgId) {
		return ptgService.getResTime(ptgId, redate);
	}

	//▶ 결제전 정보 확인페이지 (작가)
	@RequestMapping("/pay/orderForm")
	public String orderForm(ReserVO vo, SelectedOpVO svo, Model model, OptionsVO ovo) {
		model.addAttribute("pointInfo", orderService.getMemberPointInfo(vo));
		model.addAttribute("cpnInfo", orderService.getMemberCpnInfo(vo));
		return "order/orderList";
	}

	//▶ 예약 결제 API, 결제 후 테이블에 insert Ajax (작가)
	@PostMapping("/pay/reserInsert")
	@ResponseBody
	public ReserVO reserInsert(ReserVO rvo, PaymentVO pvo, SelectedOpVO svo, PointVO ptvo, UsedPointVO upvo,
			CouponHistoryVO chvo) {
		String resNum = orderService.reserInsert(rvo);
		System.out.println("insert resNum=>" + resNum);

		// 예약시 paymentInsert 테이블에 추가
		pvo.setResNum(rvo.getResNum());
		paymentService.paymentInsert(pvo);

		// 결제 시 SelectedOpVO 테이블에 추가
		svo.setResNum(pvo.getResNum());
		selectedOpService.selectedOpInsert(svo);

		// 결제시 결제 금액의 10% 포인트로 지급
		ptvo.setSaveNum(pvo.getOrdNum()); // 포인트vo에 pvo에 주문번호 넣어주기(결제금액의 10%)
		pointService.pointInsert(ptvo); // 결제하면 멤버 테이블에 pointSum에 증가

		// 결제시 사용한 포인트가 있으면!
		if (pvo.getUPoint() != 0) {
			upvo.setUsedNum(pvo.getOrdNum()); // 사용된 포인트 vo에 pvo주문 번호 넣어주기
			pointService.usedPointInsert(upvo); // 결제시 사용한 포인트테이블에 추가하고 멤버테이블에서 차감
		}
		// 결제 시 사용한 쿠폰이 있으면!
		if (pvo.getUCpNum() != null) {
			chvo.setId(pvo.getId());
			chvo.setCpnNum(pvo.getUCpNum());
			couponService.updateCoupon(chvo);
		}
		return rvo;
	}

	//▶ 결제 다 하면 주문 내역서 창 (작가)
	@RequestMapping("/pay/orderEnd/{id}")
	public String orderEnd(Model model, @PathVariable String id, ReserVO vo) {
		model.addAttribute("resInfo", paymentService.getPaymentInfo(id));
		return "order/orderEnd";
	}

	///▶ 클래스
	
	//▶ 결제전 정보 확인페이지 (클래스)
	@RequestMapping("/pay/orderFormCla")
	public String orderFormCla(ReserVO vo, SelectedOpVO svo, Model model, OptionsVO ovo, ClassesVO cvo,
			HttpSession session) {
		model.addAttribute("pointInfo", orderService.getMemberPointInfo(vo));
		model.addAttribute("cpnInfo", orderService.getMemberCpnInfo(vo));
		return "order/orderListCla";
	}
	
	//▶ 클래스 결제 API, 결제 후 테이블에 insert Ajax (클래스)
	@RequestMapping("/pay/paymentInsert")
	@ResponseBody
	public PaymentVO paymentInsert(PaymentVO pvo, PointVO ptvo, UsedPointVO upvo, CouponHistoryVO chvo) {
		String ordNum = paymentService.claPaymentInsert(pvo);
		System.out.println(ordNum);

		// 결제시 결제 금액의 10% 포인트로 지급
		ptvo.setSaveNum(pvo.getOrdNum()); // 포인트vo에 pvo에 주문번호 넣어주기(결제금액의 10%)
		pointService.pointInsert(ptvo); // 결제하면 멤버 테이블에 pointSum에 증가

		// 결제시 사용한 포인트가 있으면!
		if (pvo.getUPoint() != 0) {
			upvo.setUsedNum(pvo.getOrdNum()); // 사용된 포인트 vo에 pvo주문 번호 넣어주기
			pointService.usedPointInsert(upvo); // 결제시 사용한 포인트테이블에 추가하고 멤버테이블에서 차감
		}
		// 결제 시 사용한 쿠폰이 있으면!
		if (pvo.getUCpNum() != null) {
			chvo.setId(pvo.getId());
			chvo.setCpnNum(pvo.getUCpNum());
			couponService.updateCoupon(chvo);
		}
		return pvo;
	}

}
