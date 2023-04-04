package com.yedam.app.classes;

import java.util.List;

import com.yedam.app.members.MembersVO;

public interface ClassesDAO {

	// 정보 List에 담을꺼라서. 수강과목 전체조회
	List<ClassesVO> viewAllC();

	// 수강신청. MembersVO에서 회원번호도 받아서 넣을거라서 매개변수 2개
	void enrollC(ClassesVO csVO, MembersVO mVO);

	// 선택한 번호의 수강과목이 존재하는지, 정말 수강할건지 확인
	ClassesVO confirmC(ClassesVO csVO);

}
