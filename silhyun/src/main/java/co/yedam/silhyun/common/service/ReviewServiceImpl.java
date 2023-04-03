package co.yedam.silhyun.common.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.yedam.silhyun.common.map.PhotoMapper;
import co.yedam.silhyun.common.map.ReviewMapper;
import co.yedam.silhyun.common.vo.Criteria;
import co.yedam.silhyun.common.vo.PhotoVO;
import co.yedam.silhyun.common.vo.ReviewVO;
import co.yedam.silhyun.member.vo.PhotographerVO;
import co.yedam.silhyun.order.vo.PaymentVO;

@Service
public class ReviewServiceImpl implements ReviewService {
	@Autowired ReviewMapper mapper;
	@Autowired PhotoMapper pmapper;

	@Override
	public List<ReviewVO> reviewList(Criteria cri, String ctgr, String ctgrNum) {
		List<ReviewVO> list = new ArrayList<ReviewVO>();
		List<ReviewVO> rList = new ArrayList<ReviewVO>();
		list = mapper.reviewList(cri, ctgr, ctgrNum);
		for(ReviewVO vo : list) {
			PhotoVO pvo = new PhotoVO();
			pvo.setCtgr("R");
			pvo.setCtgrNum(vo.getRevNum());
			vo.setPhotoList(pmapper.photoList(pvo));
			rList.add(vo);
		}
		
		return rList;
	}

	@Override
	public String reviewInsert(ReviewVO vo) {
		mapper.reviewInsert(vo);
		System.out.println("리뷰번호가 넘어오는감??? ================"+vo.getRevNum());
		return vo.getRevNum();
	}

	@Override
	public int reviewUpdate(ReviewVO vo) {
		
		return mapper.reviewUpdate(vo);
	}

	@Override
	public int reviewDelete(ReviewVO vo) {
		
		return mapper.reviewDelete(vo);
	}

	@Override
	public int getTotalCount(Criteria cri,String ctgr, String ctgrNum) {
		// TODO Auto-generated method stub
		return mapper.getTotalCount(cri,ctgr,ctgrNum);
	}

	//나중에 합칠꺼
	@Override
	public PhotographerVO ptgStarAvg(String ctgr, String ctgrNum) {
	
		return mapper.ptgStarAvg(ctgr, ctgrNum);
	}

	@Override
	public ReviewVO reivewSelect(ReviewVO vo) {
		
		return mapper.reivewSelect(vo);
	}

	@Override
	public int isReviewCheck(PaymentVO vo) {
		// TODO Auto-generated method stub
		return mapper.isReviewCheck(vo);
	}

	@Override
	public List<ReviewVO> selectPayInfo(PaymentVO vo) {
		// TODO Auto-generated method stub
		return mapper.selectPayInfo(vo);
	}

	@Override
	public List<ReviewVO> reviewAllList(ReviewVO vo, Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.reviewAllList(vo, cri);
	}

	@Override
	public int getAllTotal(ReviewVO vo) {
		// TODO Auto-generated method stub
		return mapper.getAllTotal(vo);
	}

}
