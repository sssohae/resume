package co.yedam.silhyun.member.map;

import co.yedam.silhyun.member.vo.MemberVO;
import co.yedam.silhyun.member.vo.UserVO;

public interface MemberMapper {
	MemberVO memeberSelect(MemberVO vo);
	
	int memberInsert(MemberVO vo); //회원가입
	boolean isidCheck(MemberVO vo); //아이디중복검사
	
	int updateProfileImage(MemberVO vo);//프사 바꾸기
	
	//아이디 찾기 
	String findid(MemberVO vo);
	
	//비번찾기
	int isPwdChek(MemberVO vo);
}
