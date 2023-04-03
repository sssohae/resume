package co.yedam.silhyun.member.service;

import java.util.Date;
import java.util.List;

import co.yedam.silhyun.common.vo.Criteria;
import co.yedam.silhyun.common.vo.ZzimVO;
import co.yedam.silhyun.member.vo.PhotographerVO;

public interface PtgService {
	List<PhotographerVO> getPtgLsit(Criteria cri,PhotographerVO vo);
	int getTotalCount(Criteria cri,PhotographerVO vo);
	
//	List<PhotographerVO> ptgSearchList(Criteria cri,PhotographerVO vo); //다중 검색
//	int getTotalListCount(Criteria cri,PhotographerVO vo);
	List<PhotographerVO> getPtg(String ptgId);
	
	List<PhotographerVO> getReser(String ptgId);
	List<PhotographerVO> getResTime(String ptgId,String redate);
	
	boolean isZzim(ZzimVO vo);  //찜 데이터 확인
	void insertZzim(ZzimVO vo); // 찜 추가하기
	void delZzim(ZzimVO vo); //찜 삭제하기
}
