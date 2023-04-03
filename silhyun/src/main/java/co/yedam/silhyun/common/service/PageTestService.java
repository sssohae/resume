package co.yedam.silhyun.common.service;

import java.util.List;

import co.yedam.silhyun.common.vo.Criteria;
import co.yedam.silhyun.common.vo.ReviewVO;

public interface PageTestService {
	List<ReviewVO> getListReview(Criteria cri);
	int getTotalCount(Criteria cri);
}
