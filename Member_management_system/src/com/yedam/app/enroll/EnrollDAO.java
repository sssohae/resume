package com.yedam.app.enroll;

import java.util.List;

public interface EnrollDAO {

	// 수강중인 과목 조회(회원용)
	List<EnrollVO> enrolledView();

	// 회원 수강현황(운영자용)
	List<EnrollVO> enrolledViewAll();
}
