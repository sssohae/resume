package com.yedam.app.common;

import java.util.Scanner;

import com.yedam.app.members.*;

public class LoginControl {

	private Scanner sc = new Scanner(System.in);
	// 정적 필드 loginInfo만들기
	private static MembersVO loginInfo = null;

	// 이 메소드로만 호출
	public static MembersVO getLoginInfo() {
		return loginInfo;
	}

	public LoginControl() {
		while (true) {
			// 메뉴보여주기
			menuPrint();
			// 메뉴선택
			int menuNo = menuSelect();
			if (menuNo == 1) {
				// 로그인
				login();
			} else if (menuNo == 2) {
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
	private void menuPrint() {
		System.out.println("==============================================================");
		System.out.println("\t\t\t 1.로그인 2.종료");
		System.out.println("==============================================================");
	}

	// 메뉴선택
	private int menuSelect() {
		int menuNo = 0;
		try {
			menuNo = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) { // 숫자 외 입력
			//printErrorMessage();에서 같이 처리 
		}
		return menuNo;
	}

	private void printErrorMessage() {
		System.out.println("*메뉴를 다시 확인해주세요.*");
	}

	// 로그인
	private void login() {
		MembersVO inputInfo = tryLogin();

		loginInfo = MembersDAOImpl.getInstance().confirmM(inputInfo);

		if (loginInfo == null) {
			System.out.println("*회원번호 또는 비밀번호가 일치하지 않습니다.*");
			return;
		}

		if (loginInfo.getmRole() == 0) {
			new ManagerMenu().run();
		}else if(loginInfo.getmRole() ==1) {
		new MemberMenu().run();
		}
	}

	// 로그인_회원번호, 비밀번호 입력
	private MembersVO tryLogin() {
		MembersVO info = new MembersVO();
		System.out.println("회원번호 > ");
		try {
			info.setmNo(Integer.parseInt(sc.nextLine()));
		} catch (Exception e) {// 회원번호 타입 다르게 입력시
		}
		System.out.println("비밀번호 > ");
		try {
			info.setmPw(sc.nextLine());
		} catch (Exception e) {// 비밀번호 타입 다르게 입력시
		}
		return info;
	}

	// 종료
	private void exit() {
		System.out.println("접속을 종료합니다.");
	}

}
