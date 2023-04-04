package com.yedam.app.members;

import java.util.List;
import java.util.Scanner;

import com.yedam.app.enroll.EnrollMenu;

public class ManagerMenu {

	Scanner sc = new Scanner(System.in);
	MembersDAO memDAO = MembersDAOImpl.getInstance();

	public void run() {
		while (true) {
			// 메뉴보여주기
			menuPrint();
			// 메뉴선택
			int menuNo = menuSelect();

			if (menuNo == 1) {
				// 회원등록
				insertM();
			} else if (menuNo == 2) {
				// 회원삭제
				deleteM();
			} else if (menuNo == 3) {
				// 전체회원 조회
				viewAllM();
			} else if (menuNo == 4) {
				// 특정회원 조회
				viewMs();
			} else if (menuNo == 5) {
				// 회원 수강현황
				EnrollMenu enrlMenu = new EnrollMenu();
				enrlMenu.enrolledViewAll();
			} else if (menuNo == 6) {
				exit();
				break;
			} else {
				// 메뉴 외 입력시 메세지
				printErrorMessage();
			}
		}
	}

	// 메뉴
	protected void menuPrint() {
		System.out.println("==============================================================");
		System.out.println("1.회원등록 2.회원삭제 3.전체회원 조회 4.특정회원 조회 5.회원 수강현황 6.종료");
		System.out.println("==============================================================");
	}

	// 메뉴선택
	protected int menuSelect() {
		int menuNo = 0;
		try {
			menuNo = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			//printErrorMessage();에서 같이 처리 
		}
		return menuNo;
	}

	protected void printErrorMessage() {
		System.out.println("*메뉴를 다시 확인해주세요.*");
	}

	// 회원등록시 정보입력
	private MembersVO inputMs() {
		MembersVO memVO = new MembersVO();
		try {
			System.out.println("회원번호>");
			memVO.setmNo(Integer.parseInt(sc.nextLine()));
			System.out.println("회원이름>");
			memVO.setmName(sc.nextLine());
			System.out.println("비밀번호>");
			memVO.setmPw(sc.nextLine());
			System.out.println("생년월일>");
			memVO.setbDay(Integer.parseInt(sc.nextLine()));
			System.out.println("성별(M,F)>");
			memVO.setGender(sc.nextLine());
			System.out.println("거주지>");
			memVO.setAddress(sc.nextLine());
			System.out.println("연락처>");
			memVO.setContact(sc.nextLine());
			System.out.println("권한");
			memVO.setmRole(Integer.parseInt(sc.nextLine()));
		} catch (Exception e) {
			// 입력 때 오류 한번에 처리하
		}
		return memVO;
	}

	// 회원등록
	private void insertM() {
		// 위에서 처리한 정보 Impl로 보내기
		MembersVO memVO = inputMs();
		memDAO.insertM(memVO);
	}

	// 회원삭제
	private void deleteM() {
		System.out.println("삭제할 회원번호를 입력하세요.");
		int mNo = inputMNo();
		memDAO.deleteM(mNo);

	}

	// 회원번호 입력_회원삭제에 쓸 것
	private int inputMNo() {
		int memNo = 0;
		try {
			memNo = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("*회원번호는 숫자로 구성되어 있습니다.*");
		}
		return memNo;
	}

	// 전체회원 조회
	private void viewAllM() {
		List<MembersVO> list = memDAO.viewAllM();

		if (list.isEmpty()) {
			System.out.println("*정보가 존재하지 않습니다.*");
			return;
		}
		for (MembersVO memVO : list) {
			System.out.printf("회원번호 %d:\t%s, %s, %d, %s, %s, %s, %d\n", memVO.getmNo(), memVO.getmName(),
					memVO.getmPw(), memVO.getbDay(), memVO.getGender(), memVO.getAddress(), memVO.getContact(),
					memVO.getmRole());
		}
	}

	// 특정회원 조회
	private void viewMs() {
		MembersVO findMems = inputMsInfo();
		List<MembersVO> list = memDAO.viewMs(findMems);
		if (list.isEmpty()) {
			System.out.printf("*%s회원은 존재하지 않습니다.* \n", findMems.getmName());
			return;
		}
		for (MembersVO memVO : list) {
			System.out.println("조회결과 >");
			System.out.printf("회원번호 %d:\t%s, %s, %d, %s, %s, %s, %d\n", memVO.getmNo(), memVO.getmName(),
					memVO.getmPw(), memVO.getbDay(), memVO.getGender(), memVO.getAddress(), memVO.getContact(),
					memVO.getmRole());
		}
	}

	// 회원이름 입력_특정회원 조회에 쓸 것
	private MembersVO inputMsInfo() {
		MembersVO inputmVO = new MembersVO();
		System.out.println("이름>");
		inputmVO.setmName(sc.nextLine());
		return inputmVO;
	}

	// 종료
	protected void exit() {
	}
}
