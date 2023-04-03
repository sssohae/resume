package co.yedam.silhyun.event.map;

import java.util.List;

import co.yedam.silhyun.event.vo.CouponHistoryVO;
import co.yedam.silhyun.event.vo.CouponVO;

public interface CouponMapper {
	
	 List<CouponVO> couponSelectList();//전체
	 int insertCoupon(CouponHistoryVO vo); 		//쿠폰 히스토리 삽입
		int updateCoupon(CouponHistoryVO hvo); // 결제시 쿠폰 사용하면 히스토리에 상태 변경
}
