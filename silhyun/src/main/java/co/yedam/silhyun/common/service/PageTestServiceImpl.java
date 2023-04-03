package co.yedam.silhyun.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.yedam.silhyun.common.map.PageTestMapper;
import co.yedam.silhyun.common.vo.Criteria;
import co.yedam.silhyun.common.vo.ReviewVO;

@Service
public class PageTestServiceImpl implements PageTestService {
	
	@Autowired PageTestMapper map;

	@Override
	public List<ReviewVO> getListReview(Criteria cri) {
		// TODO Auto-generated method stub
		return map.getListReview(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		// TODO Auto-generated method stub
		return map.getTotalCount(cri);
	}

}
