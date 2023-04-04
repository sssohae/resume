package com.yedam.app.enroll;

import java.util.List;

public class EnrollMenu {
	EnrollDAO enrlDAO = EnrollDAOImpl.getInstance();

	// 수강 중인 과목 조회
	public void enrolledView() {
		List<EnrollVO> list = enrlDAO.enrolledView();

		if (list.isEmpty()) {
			System.out.println("*수강 중인 과목이 없습니다.*");
			return;
		}

		for (EnrollVO enrlVO : list) {
			System.out.printf("과목번호: %d 과목이름: %s 개강일: %s 종강일: %s 신청일: %s\n", enrlVO.getcNo(), enrlVO.getcName(),
					enrlVO.getFromDate(), enrlVO.getToDate(), enrlVO.getEnrollDate());
		}

	}

	// 회원 수강현황
	public void enrolledViewAll() {
		List<EnrollVO> list = enrlDAO.enrolledViewAll();

		if (list.isEmpty()) {
			System.out.println("*수강 중인 과목이 없습니다.*");
			return;
		}

		for (EnrollVO enrlVO : list) {
			System.out.printf("과목번호: %d 과목이름: %s 개강일: %s 종강일: %s 신청일: %s, 회원번호: %d\n", enrlVO.getcNo(),
					enrlVO.getcName(), enrlVO.getFromDate(), enrlVO.getToDate(), enrlVO.getEnrollDate(),
					enrlVO.getmNo());
		}
	}

}
