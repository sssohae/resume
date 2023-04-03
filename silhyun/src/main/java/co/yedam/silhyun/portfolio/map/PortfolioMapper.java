package co.yedam.silhyun.portfolio.map;

import java.util.List;

import co.yedam.silhyun.common.vo.PhotoVO;
import co.yedam.silhyun.member.vo.PhotographerVO;
import co.yedam.silhyun.portfolio.vo.LikePhotoVO;
import co.yedam.silhyun.portfolio.vo.PortfolioVO;
import co.yedam.silhyun.portfolio.vo.TagVO;

public interface PortfolioMapper {

	int findLike(LikePhotoVO like);// 조아요 데이터 찾기

	void insertLike(LikePhotoVO like);// 조아요 추가하기

	void deleteLike(LikePhotoVO like);// 좋아요 삭제하기


	List<PortfolioVO> detailPortfolioPhoto(String portNum);//모달포트폴리오사진
	
	
	List<PhotographerVO> portfolioPtg(String ptgId);//포트폴리오상세페이지작가정보
	List<PhotographerVO> ptgField(String ptgId);//작가필드리스트
	
	List<PortfolioVO> ptgPortfolioList(String ptgId);//작가별 포트폴리오리스트 띄우기
	
	
	//포트폴리오 인서트
	void insertPortfolio(PortfolioVO portfolioVO);
	void insertPhoto(PhotoVO photoVO);
	void insertTag(TagVO tagVO);
	
	
	List<PortfolioVO> imsiList(String ptgId);//작가별 임시리스트 띄우기
	PortfolioVO portfolioSelectOne(String portNum);//포트폴리오selectOne

	void portfolioUpdate(PortfolioVO vo);//포트폴리오 업데이트

	int deletePortLike(String portNum);//걸려잇는like지우기.
	void deletePortfolio(String portNum);

	List<PortfolioVO> selectPortLike(String portNum);


}
