package co.yedam.silhyun.portfolio.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.yedam.silhyun.common.vo.PhotoVO;
import co.yedam.silhyun.member.vo.PhotographerVO;
import co.yedam.silhyun.portfolio.map.PortfolioMapper;
import co.yedam.silhyun.portfolio.vo.LikePhotoVO;
import co.yedam.silhyun.portfolio.vo.PortfolioVO;
import co.yedam.silhyun.portfolio.vo.TagVO;

@Service
public class PortfolioServiceImpl implements PortfolioService {

	@Autowired
	private PortfolioMapper portfolioMapper;

	@Override // 조아요 확인
	public boolean isLiked(LikePhotoVO like) {
		int count = portfolioMapper.findLike(like);
		return count > 0;
	}

	@Override // 조아요 추가하기
	public void addLike(LikePhotoVO like) {
		portfolioMapper.insertLike(like);
	}

	@Override // 조아요삭제하기
	public void removeLike(LikePhotoVO like) {
		portfolioMapper.deleteLike(like);
	}

	@Override // 포트폴리오클릭한거사진리스트;
	public List<PortfolioVO> detailPortfolioPhoto(String portNum) {
		return portfolioMapper.detailPortfolioPhoto(portNum);
	}

	@Override // 포트폴리오상세페이지작가정보
	public List<PhotographerVO> portfolioPtg(String ptgId) {
		return portfolioMapper.portfolioPtg(ptgId);
	}

	@Override // 작가필드리스트
	public List<PhotographerVO> ptgField(String ptgId) {
		return portfolioMapper.ptgField(ptgId);
	}

	@Override // 작가별 포트폴리오리스트 띄우기
	public List<PortfolioVO> ptgPortfolioList(String ptgId) {
		// TODO Auto-generated method stub
		return portfolioMapper.ptgPortfolioList(ptgId);
	}

	@Override
	public String insertPortfolio(List<MultipartFile> files, PortfolioVO portfolioVO) {
		// portfolio 테이블에 데이터 삽입

		portfolioMapper.insertPortfolio(portfolioVO);

		// tag 테이블에 데이터 삽입
		ObjectMapper objectMapper = new ObjectMapper();
		TagVO[] tagCntns = null;
		try {
			tagCntns = objectMapper.readValue(portfolioVO.getTagCntn(), TagVO[].class);
			System.out.println(tagCntns[0].getTagCntn() + "sssssssssssssssssssss");
			for (TagVO tagVO : tagCntns) {
				portfolioMapper.insertTag(tagVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return portfolioVO.getPortNum();
	}

	@Override // 작가별 임시리스
	public List<PortfolioVO> imsiList(String ptgId) {
		// TODO Auto-generated method stub
		return portfolioMapper.imsiList(ptgId);
	}

	@Override
	public PortfolioVO portfolioSelectOne(String portNum) {
		// TODO Auto-generated method stub
		return portfolioMapper.portfolioSelectOne(portNum);
	}

	@Override
	public String updatePortfolio(PortfolioVO vo) {
		// 포트폴리오 정보 update
		portfolioMapper.portfolioUpdate(vo);
		return vo.getPortNum();
	}


	@Override
	public void deletePortfolio(String portNum) {
	    List<PortfolioVO> selectPortLikeResult = portfolioMapper.selectPortLike(portNum);
	    if (selectPortLikeResult == null || selectPortLikeResult.size() == 0) {
	        portfolioMapper.deletePortfolio(portNum);
	    } else {
	    	int deletePortLike = portfolioMapper.deletePortLike(portNum);
	    	if(deletePortLike>0) {
	        portfolioMapper.deletePortfolio(portNum);}
	    }
	}
}
