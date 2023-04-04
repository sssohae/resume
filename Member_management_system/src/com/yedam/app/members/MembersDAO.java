package com.yedam.app.members;

import java.util.List;

public interface MembersDAO {

	// MembersVO타입 List. 저장용량이 자동증가, 객체 저장할 때 자동 인덱스 부여. null도 저장 가능
	// 모든 회원보기
	List<MembersVO> viewAllM();

	// 해당하는 회원(들)만 보기
	List<MembersVO> viewMs(MembersVO msVO);

	// 회원 등록
	void insertM(MembersVO msVO);

	// 회원 정보수정
	void updateM(MembersVO msVO);

	// 회원 삭제
	void deleteM(int mNo);

	// 로그인할때 정보확인
	public MembersVO confirmM(MembersVO msVO);

}
