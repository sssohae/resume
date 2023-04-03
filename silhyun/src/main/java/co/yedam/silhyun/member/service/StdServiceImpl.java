package co.yedam.silhyun.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.yedam.silhyun.common.vo.Criteria;
import co.yedam.silhyun.member.map.StdMapper;
import co.yedam.silhyun.member.vo.PhotographerVO;
import co.yedam.silhyun.member.vo.StudioVO;
@Service
public class StdServiceImpl implements StdService {
	@Autowired StdMapper stdMapper;

	@Override
	public List<StudioVO> getStdList(Criteria cri, StudioVO vo) {
		return stdMapper.getStdList(cri, vo);
	}

	@Override
	public int getTotalCount(Criteria cri, StudioVO vo) {
		return stdMapper.getTotalCount(cri, vo);
	}

	@Override
	public List<StudioVO> getStd(String stdId) {
		return stdMapper.getStd(stdId);
	}

	@Override
	public List<StudioVO> getReserList(String stdId) {
		return stdMapper.getReserList(stdId);
	}

	@Override
	public List<PhotographerVO> ptgList(String stdId) {

		return stdMapper.ptgList(stdId);
	}

	@Override
	public List<StudioVO> stdlistget(String stdId) {

		return stdMapper.stdlistget(stdId);
	}

	@Override
	public int ptgdel(String ptgId) {
		
		return stdMapper.ptgdel(ptgId);
	}

	@Override
	public int updatestProfileImage(StudioVO vo) {

		return stdMapper.updatestProfileImage(vo);
	}
	
	

}
