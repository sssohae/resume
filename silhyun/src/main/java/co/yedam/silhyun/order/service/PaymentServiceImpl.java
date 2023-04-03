package co.yedam.silhyun.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.yedam.silhyun.order.map.PaymentMapper;
import co.yedam.silhyun.order.vo.PaymentVO;
@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired PaymentMapper paymentMapper;

	@Override
	public String paymentInsert(PaymentVO vo) {
		paymentMapper.paymentInsert(vo);  //payment테이블에 넣고 
		
		return vo.getResNum(); //예약 번호 리턴
	}

	@Override
	public List<PaymentVO> getPaymentInfo(String id) {
		
		return paymentMapper.getPaymentInfo(id);
	}

	@Override
	public String claPaymentInsert(PaymentVO vo) {
		paymentMapper.claPaymentInsert(vo);
		return vo.getOrdNum();
	}

}
