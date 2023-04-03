package co.yedam.silhyun.order.service;

import java.util.List;

import co.yedam.silhyun.order.vo.PaymentVO;

public interface PaymentService {
	String paymentInsert(PaymentVO vo);
	List<PaymentVO> getPaymentInfo(String id);
	
	String claPaymentInsert(PaymentVO vo);
}
