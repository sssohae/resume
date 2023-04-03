package co.yedam.silhyun.portfolio.map;

import java.util.List;

import co.yedam.silhyun.portfolio.vo.PortfolioVO;
import co.yedam.silhyun.portfolio.vo.TagVO;

public interface AroundMapper {
	List<PortfolioVO> getAroundList(); // 모든포트폴리오 불러오기
	List<PortfolioVO> aroundTagList(PortfolioVO tagCntn); //태그별로 보이기
	List<TagVO> tagList();//태그리스트
	List<String> searchTags(String tag);//태그 ul만들기
	
	
	
}
