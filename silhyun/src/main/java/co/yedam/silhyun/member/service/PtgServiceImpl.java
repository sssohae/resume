package co.yedam.silhyun.member.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.yedam.silhyun.common.vo.Criteria;
import co.yedam.silhyun.common.vo.ZzimVO;
import co.yedam.silhyun.member.map.PtgMapper;
import co.yedam.silhyun.member.vo.PhotographerVO;
@Service
public class PtgServiceImpl implements PtgService {
	@Autowired 
	private PtgMapper ptgMapper;
	
	@Override  //작가 전체 조회
	public List<PhotographerVO> getPtgLsit(Criteria cri,PhotographerVO vo) {
		return ptgMapper.getPtgLsit(cri,vo);
	}
	@Override
	public int getTotalCount(Criteria cri, PhotographerVO vo) {
		return ptgMapper.getTotalCount(cri, vo);
	}
//	@Override  //작가 전체 조회
//	public List<PhotographerVO> getPtgLsit(String searchType) {
//		return ptgMapper.getPtgLsit(searchType);
//	}

//	@Override
//	public List<PhotographerVO> ptgSearchList(Criteria cri,PhotographerVO vo) {
//		// 
//		return ptgMapper.ptgSearchList(cri,vo);
//	}
//	@Override
//	public int getTotalListCount(Criteria cri, PhotographerVO vo) {
//		//
//		return ptgMapper.getTotalListCount(cri, vo);
//	}

	@Override
	public List<PhotographerVO> getPtg(String ptgId) {
		return ptgMapper.getPtg(ptgId);
	}
	@Override
	public List<PhotographerVO> getReser(String ptgId) {
		return ptgMapper.getReser(ptgId);
	}

	@Override
	public List<PhotographerVO> getResTime(String ptgId, String redate) {
		return ptgMapper.getResTime(ptgId,redate);
	}
	@Override  //찜 확인
	public boolean isZzim(ZzimVO vo) {
		int count = ptgMapper.findZzim(vo);
		return count > 0;
	}
	@Override  //찜 추가
	public void insertZzim(ZzimVO vo) {
		ptgMapper.insertZzim(vo);
	}
	@Override //찜 삭제
	public void delZzim(ZzimVO vo) {
		ptgMapper.delZzim(vo);
	}



}
