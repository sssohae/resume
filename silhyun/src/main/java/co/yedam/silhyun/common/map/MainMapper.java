package co.yedam.silhyun.common.map;

import java.util.List;

import co.yedam.silhyun.common.vo.ReviewVO;
import co.yedam.silhyun.event.vo.EventVO;
import co.yedam.silhyun.member.vo.FieldVO;
import co.yedam.silhyun.member.vo.PhotographerVO;
import co.yedam.silhyun.portfolio.vo.PortfolioVO;

public interface MainMapper {
	List<PhotographerVO> getHotPtg(PhotographerVO vo); // 인기 작가 
	List<PhotographerVO> getNewPtg(PhotographerVO vo);  //최신 작가
	List<PortfolioVO> getPtgPortfolioList(PortfolioVO vo);//작가 포트폴리오리스트 랜덤으로 띄우기 
	List<EventVO> getEventList(EventVO vo); //이벤트 배너 사진
	List<ReviewVO> getReviewA(ReviewVO vo); //작가 리뷰 최신순으로 가지고 오기
	List<ReviewVO> getReviewC(ReviewVO vo); //클래스 리뷰 최신순으로 가지고 오기
	List<ReviewVO> getReview(ReviewVO vo); //리뷰 별점 5개 가지고 오기
	List<FieldVO> getFeildList(FieldVO vo);// 필드 가지고와서 태그로 만들기
	
	List<PhotographerVO> getTagPtgList(String fdCd);
	List<PhotographerVO> getPtgPort(String ptgId);
}
