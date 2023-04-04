package com.yedam.app.classes;

import java.util.List;
import java.util.Scanner;

import com.yedam.app.common.LoginControl;
import com.yedam.app.enroll.EnrollMenu;
import com.yedam.app.members.MembersVO;

public class ClassesMenu {

	Scanner sc = new Scanner(System.in);

	ClassesDAO clsDAO = ClassesDAOImpl.getInstance();

	public void run() {
		while (true) {
			// 메뉴보여주기
			menuPrint();
			// 메뉴선택
			int menuNo = menuSelect();

			if (menuNo == 1) {
				// 수강과목 전체조회
				viewAllC();
			} else if (menuNo == 2) {
				// 수강신청
				enrollC();
			} else if (menuNo == 3) {
				// 수강중인 과목 조회
				EnrollMenu enrlMenu = new EnrollMenu();
				enrlMenu.enrolledView();
			} else if (menuNo == 4) {
				// 이전 메뉴로 돌아가기
				exit();
				break;
			} else {
				// 메뉴 외 입력시 메세지
				printErrorMessage();
			}
		}
	}

	// 메뉴
	private void menuPrint() {
		System.out.println("==============================================================");
		System.out.println("   1.수강과목 전체조회 2.수강신청 3.수강중인 과목 조회 4.돌아가기");
		System.out.println("==============================================================");
	}

	// 메뉴선택
	private int menuSelect() {
		int menuNo = 0;
		try {
			menuNo = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			//printErrorMessage();에서 같이 처리
		}
		return menuNo;
	}

	private void printErrorMessage() {
		System.out.println("*메뉴를 다시 확인해주세요.*");
	}

	// 수강과목 전체조회
	private void viewAllC() {
		List<ClassesVO> list = clsDAO.viewAllC();

		if (list.isEmpty()) {
			System.out.println("*현재 모집중인 과목이 없습니다.*");
		}
		for (ClassesVO csVO : list) {
			System.out.printf("과목번호 : %d 분류 : %s\t 과목명 : %s\t\t개강일 : %s 종강일 : %s\n", csVO.getcNo(), csVO.getcName(),
					csVO.getcIntro(), csVO.getFromDate(), csVO.getToDate());
		}

	}

	// 수강할 과목번호 입력
	private ClassesVO inputCNo() {
		ClassesVO cInput = new ClassesVO();
		System.out.println("수강할 과목번호를 입력해주세요.");
		try {
			cInput.setcNo(Integer.parseInt(sc.nextLine()));
		} catch (Exception e) {
		}
		return cInput;
	}

	// 입력한 수강과목에 대한 확인
	private ClassesVO confirmC() {
		ClassesVO csInfo = inputCNo();
		ClassesVO ckCsVO = clsDAO.confirmC(csInfo);
		// 없는 내용 넣었는지 확인
		if (ckCsVO == null) {
			System.out.println("*없는 과목번호입니다. 다시 확인해주세요.* \n");
			exit();
		} else {
			System.out.println("수강할 과목을 확인해주세요. >");
			System.out.printf("과목번호 : %d 분류 : %s 과목명 : %s\t개강일 : %s 종강일 : %s\n", ckCsVO.getcNo(), ckCsVO.getcName(),
					ckCsVO.getcIntro(), ckCsVO.getFromDate(), ckCsVO.getToDate());
			// 정말 수강할 건지 물어보기
			System.out.println("수강하시려면 Y나 y를 눌러주세요.");
			String answer = sc.nextLine();
			if (answer.equals("Y") || answer.equals("y")) {
				ckCsVO = clsDAO.confirmC(ckCsVO);
			} else {
				System.out.println("*취소되었습니다.*");
				ckCsVO = null;
			}
		}
		return ckCsVO;

	}

	// 수강신청
	private void enrollC() {
		ClassesVO cfCsVO = confirmC();
		MembersVO memVO = LoginControl.getLoginInfo();
		if (cfCsVO == null) {
			exit();
		} else {

			clsDAO.enrollC(cfCsVO, memVO);
		}
	}

	// 종료
	private void exit() {
	}

}
