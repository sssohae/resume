package co.nambaone.prj.user.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.nambaone.prj.common.Command;

public class UserLogout implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 로그아웃 처리
		HttpSession session = request.getSession();
		String message = (String) session.getAttribute("Nickname");
		message += "님 안녕히 가십시오";
		session.invalidate(); // 서버에 만들어놓은 세션을 완전히 삭제
		request.setAttribute("message", message);
		return "user/userLogin.tiles";
	}

}
