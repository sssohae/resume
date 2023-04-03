package co.yedam.silhyun.common.map;

import java.util.List;

import co.yedam.silhyun.common.vo.Criteria;
import co.yedam.silhyun.common.vo.ReviewVO;

public interface PageTestMapper {
	List<ReviewVO> getListReview(Criteria cri);
	int getTotalCount(Criteria cri);
}
