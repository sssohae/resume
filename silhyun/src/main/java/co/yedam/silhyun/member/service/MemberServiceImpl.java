package co.yedam.silhyun.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.yedam.silhyun.member.map.MemberMapper;
import co.yedam.silhyun.member.vo.MemberVO;
import co.yedam.silhyun.member.vo.UserVO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired MemberMapper map;

	@Override
	public MemberVO memeberSelect(MemberVO vo) {
		
		return map.memeberSelect(vo);
	}

	@Override
	public int memberInsert(MemberVO vo) {
		
		return map.memberInsert(vo);
	}

	@Override
	public boolean isidCheck(MemberVO vo) {
		
		return map.isidCheck(vo);
	}
	
	//프사
	@Override
	public int updateProfileImage(MemberVO vo) {

		return map.updateProfileImage(vo);
	}

	@Override
	public String findid(MemberVO vo) {
		// TODO Auto-generated method stub
		return map.findid(vo);
	}

	@Override
	public int isPwdChek(MemberVO vo) {
		// TODO Auto-generated method stub
		return map.isPwdChek(vo);
	}
	

}
