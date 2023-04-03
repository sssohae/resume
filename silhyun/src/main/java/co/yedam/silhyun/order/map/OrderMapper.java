package co.yedam.silhyun.order.map;

import java.util.List;
import java.util.Map;

import co.yedam.silhyun.order.vo.ReserVO;

public interface OrderMapper {
	List<ReserVO> getMemberPointInfo(ReserVO vo);
	List<ReserVO> getMemberCpnInfo(ReserVO vo);
	
	int reserInsert(ReserVO vo);  //예약 테이블 등록
}
