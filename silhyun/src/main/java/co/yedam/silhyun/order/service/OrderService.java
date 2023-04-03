package co.yedam.silhyun.order.service;

import java.util.List;
import java.util.Map;

import co.yedam.silhyun.order.vo.ReserVO;

public interface OrderService {
	List<ReserVO> getMemberPointInfo(ReserVO vo);
	List<ReserVO> getMemberCpnInfo(ReserVO vo);
	String reserInsert(ReserVO vo);
}
