package co.yedam.silhyun.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.yedam.silhyun.common.map.MainMapper;
import co.yedam.silhyun.common.vo.ReviewVO;
import co.yedam.silhyun.event.vo.EventVO;
import co.yedam.silhyun.member.vo.FieldVO;
import co.yedam.silhyun.member.vo.PhotographerVO;
import co.yedam.silhyun.portfolio.vo.PortfolioVO;
@Service
public class MainServiceImpl implements MainService{
	@Autowired MainMapper mainMapper;

	@Override
	public List<PhotographerVO> getHotPtg(PhotographerVO vo) {
		return mainMapper.getHotPtg(vo);
	}

	@Override
	public List<PhotographerVO> getNewPtg(PhotographerVO vo) {
		return mainMapper.getNewPtg(vo);
	}

	@Override
	public List<PortfolioVO> getPtgPortfolioList(PortfolioVO vo) {
		return mainMapper.getPtgPortfolioList(vo);
	}

	@Override
	public List<EventVO> getEventList(EventVO vo) {
		return mainMapper.getEventList(vo);
	}

	@Override
	public List<ReviewVO> getReviewA(ReviewVO vo) {
		return mainMapper.getReviewA(vo);
	}

	@Override
	public List<FieldVO> getFeildList(FieldVO vo) {
		return mainMapper.getFeildList(vo);
	}

	@Override
	public List<PhotographerVO> getTagPtgList(String fdCd) {
		return mainMapper.getTagPtgList(fdCd);
	}

	@Override
	public List<PhotographerVO> getPtgPort(String ptgId) {
		return mainMapper.getPtgPort(ptgId);
	}

	@Override
	public List<ReviewVO> getReviewC(ReviewVO vo) {
		return mainMapper.getReviewC(vo);
	}

	@Override
	public List<ReviewVO> getReview(ReviewVO vo) {
		return  mainMapper.getReview(vo);
	}
	
	
	
}
