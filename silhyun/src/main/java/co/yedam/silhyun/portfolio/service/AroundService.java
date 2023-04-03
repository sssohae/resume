package co.yedam.silhyun.portfolio.service;

import java.util.List;

import co.yedam.silhyun.portfolio.vo.PortfolioVO;
import co.yedam.silhyun.portfolio.vo.TagVO;

public interface AroundService {

	List<PortfolioVO> getAroundList(); // 둘러보기 들어가면 보이는 어쩌구
	List<PortfolioVO> aroundTagList(PortfolioVO tagCntn); // 태그별로 보이기
	List<TagVO> tagList();//태그리스트
	List<String> searchTags(String tag);//태그 ul만들기
	
}
