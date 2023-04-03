package co.yedam.silhyun.common.map;

import java.util.List;

import co.yedam.silhyun.common.vo.Criteria;
import co.yedam.silhyun.common.vo.ReviewVO;
import co.yedam.silhyun.member.vo.PhotographerVO;
import co.yedam.silhyun.order.vo.PaymentVO;

public interface ReviewMapper {
	List<ReviewVO> reviewList(Criteria cri, String ctgr, String ctgrNum);  //페이징+ 검색
	int getTotalCount(Criteria cri,String ctgr, String ctgrNum); //페이지 총 수 
	ReviewVO reivewSelect(ReviewVO vo); //수정시 필요한 단건조회
	int reviewInsert(ReviewVO vo); //리뷰입력
	int reviewUpdate(ReviewVO vo); //리뷰수정
	int reviewDelete(ReviewVO vo); //리뷰삭제
	
	int isReviewCheck(PaymentVO vo); //리뷰작성시 예약내역 체크
	
	PhotographerVO ptgStarAvg(String ctgr, String ctgrNum); //평균별점
	
	//예약내역에 리뷰 있는지 확인후 정보 불러오기
	//ctgrNum => ptgId/classNum
	List<ReviewVO> selectPayInfo(PaymentVO vo);
	
	//리뷰 둘러보기 리스트
	List<ReviewVO> reviewAllList(ReviewVO vo, Criteria cri);
	int getAllTotal(ReviewVO vo);

}
