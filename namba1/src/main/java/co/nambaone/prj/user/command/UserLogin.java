package co.nambaone.prj.user.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.nambaone.prj.common.Command;
import co.nambaone.prj.user.service.UserService;
import co.nambaone.prj.user.service.UserVO;
import co.nambaone.prj.user.serviceImpl.UserServiceImpl;

public class UserLogin implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 로그인 처리
		UserService dao = new UserServiceImpl();
		UserVO vo = new UserVO();
		HttpSession session = request.getSession(); // 서버가 만들어 보관하고 있는 세션객체를 호출
		
		String password = request.getParameter("userPassword");
		
		String message = null;
		vo.setUserEmail(request.getParameter("userEmail"));
		vo.setUserPassword(password);
		
		vo = dao.userSelect(vo);
		if(vo != null) {
			session.setAttribute("userEmail", vo.getUserEmail());
			session.setAttribute("Nickname", vo.getUserNickname());
			session.setAttribute("userTel", vo.getUserTel());
			session.setAttribute("joinDate", vo.getJoinDate());
			session.setAttribute("userAuthor", vo.getUserAuthor());
			session.setAttribute("cardNumber", vo.getCardNumber());
			session.setAttribute("userPassword", vo.getUserPassword());
			message = vo.getUserNickname() + "님 안녕하세요.";
			request.setAttribute("message", message);
			return "movie/main.tiles";
		} else {
			message = "아이디 또는 패스워드가 틀립니다.";
			request.setAttribute("message", message);
		}
		
		return "user/userJoin.tiles";
	}

}
