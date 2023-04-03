package co.yedam.silhyun.order.map;

import java.util.List;

import co.yedam.silhyun.order.vo.PaymentVO;
import co.yedam.silhyun.order.vo.ReserVO;

public interface PaymentMapper {
	int paymentInsert(PaymentVO vo);  //결제정보 저장
	List<PaymentVO> getPaymentInfo(String id); //결제 후 결제 정보 띄우기
	
	int claPaymentInsert(PaymentVO vo);
	
}
