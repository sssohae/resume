package com.yedam.app.members;

import java.util.Scanner;

import com.yedam.app.classes.ClassesMenu;
import com.yedam.app.common.LoginControl;

public class MemberMenu {

	protected Scanner sc = new Scanner(System.in);
	protected MembersDAOImpl mDAO = MembersDAOImpl.getInstance();

	public void run() {
		while (true) {
			// 메뉴보여주기
			menuPrint();
			// 메뉴선택
			int menuNo = menuSelect();

			if (menuNo == 1) {
				// 회원정보 수정
				update();
			} else if (menuNo == 2) {
				// 수강신청_다른 패키지에 있다
				new ClassesMenu().run();
			} else if (menuNo == 3) {
				// 종료
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
		System.out.println("\t\t1.회원정보 수정 2.수강신청 3.종료");
		System.out.println("==============================================================");
	}

	// 메뉴선택
	protected int menuSelect() {
		int menuNo = 0;
		try {
			menuNo = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			//printErrorMessage(); 에서 같이 처리 
		}
		return menuNo;
	}

	protected void printErrorMessage() {
		System.out.println("*메뉴를 다시 확인해주세요.*");
	}

	// 회원정보 수정_정보 입력하기
	private MembersVO updateInfo() {
		MembersVO inputMVO = new MembersVO();
		System.out.println("새로운 주소 >");
		inputMVO.setAddress(sc.nextLine());
		System.out.println("새로운 연락처 >");
		inputMVO.setContact(sc.nextLine());
		System.out.println("비밀번호를 입력하세요.");
		try {
			inputMVO.setmPw(sc.nextLine());
		} catch (Exception e) {

		}
		
		MembersVO mVO = LoginControl.getLoginInfo();
		inputMVO.setmNo(mVO.getmNo());
		
		if (!inputMVO.getmPw().equals(mVO.getmPw())) {
			inputMVO = null;
		}
		return inputMVO;
	}
	// 회원정보 수정
	private void update() {
		MembersVO memVO = updateInfo();
		mDAO.updateM(memVO);
	}

	// 종료
	protected void exit() {
		System.out.println("프로그램을 종료합니다.");
	}

}
