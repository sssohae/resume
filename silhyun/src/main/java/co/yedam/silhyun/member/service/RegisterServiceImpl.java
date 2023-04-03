package co.yedam.silhyun.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.yedam.silhyun.member.map.RegisterMapper;
import co.yedam.silhyun.member.vo.FieldVO;
import co.yedam.silhyun.member.vo.MemberVO;
import co.yedam.silhyun.member.vo.PhotographerVO;
import co.yedam.silhyun.member.vo.StudioVO;
@Service
public class RegisterServiceImpl implements RegisterService {
	@Autowired 
	RegisterMapper registerMapper;
	
	@Override
	public MemberVO getMember(String id) {
		return registerMapper.getMember(id);
	}

	@Override
	public String ptgRegiInsert(PhotographerVO vo) {
		registerMapper.ptgRegiInsert(vo);
		return vo.getPtgId();
	}

	@Override
	public int ptgFldRegiInsert(FieldVO vo) {
		return registerMapper.ptgFldRegiInsert(vo);
	}

	@Override
	public int stdRegiInsert(StudioVO vo) {
		return registerMapper.stdRegiInsert(vo);
	}


}
