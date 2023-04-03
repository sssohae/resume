package co.yedam.silhyun.event.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.yedam.silhyun.event.service.CouponService;
import co.yedam.silhyun.event.vo.CouponHistoryVO;

@Controller
public class CouponController {
	
	@Autowired
	private CouponService couponService;

	//쿠폰페이지
	@RequestMapping("/silhyun/eventCoupon")
	public String eventCoupon(Model model) {
		model.addAttribute("couponList", couponService.couponSelectList());
		return "coupon/eventCoupon";
	}
	
	//쿠폰 얻기
	@PostMapping("/silhyun/getCoupon")
	@ResponseBody
	public boolean getCoupon(CouponHistoryVO hvo,Model model ,HttpSession session) {
		String id = (String) session.getAttribute("id");
		hvo.setId(id);
		couponService.insertCoupon(hvo);
	
		return true;
	}
}
