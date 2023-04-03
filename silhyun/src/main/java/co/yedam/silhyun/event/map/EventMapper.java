package co.yedam.silhyun.event.map;

import java.util.List;

import co.yedam.silhyun.event.vo.EventVO;
import co.yedam.silhyun.mypage.vo.ChulcheckVO;
import co.yedam.silhyun.mypage.vo.PointVO;

public interface EventMapper {

	List<EventVO> getEventList();	//전체
	List<EventVO> getBannerList(); 	//배너리스트
	
	//출석체크
	int insertChulcheck(ChulcheckVO vo);		//출첵
	List<ChulcheckVO> chulIdSelect(String id);	//했는지 한명씩 정보불러오기
	int updateChulcheck(ChulcheckVO vo); 		//출쳌 업데이트
	List<ChulcheckVO> recentlyDate(String id);	//제일 최근 날짜 가져오기
	int updatePointChul(PointVO vo); 		//포인트
}
