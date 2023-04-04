package co.nambaone.prj.user.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.nambaone.prj.common.Command;
import co.nambaone.prj.user.service.UserService;
import co.nambaone.prj.user.service.UserVO;
import co.nambaone.prj.user.serviceImpl.UserServiceImpl;

public class UserJoin implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 회원가입 처리
		UserService dao = new UserServiceImpl();
		UserVO vo = new UserVO();
		String password = request.getParameter("userPassword");

		
		int n = 0;
		String message = null;

		vo.setUserEmail(request.getParameter("userEmail"));
		vo.setUserNickname(request.getParameter("userNickname"));
		vo.setUserPassword(password);

		n = dao.userInsert(vo);
		
		
		if (n != 0) {
//			message = "회원가입이 성공적으로 처리되었다.";
			return  "main.do";
		} else {
			message = "회원가입이 실패했습니다.";
		}
		request.setAttribute("message", message);
		
		return "user/signUp.tiles";
	}
}
