package co.nambaone.prj.user.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.nambaone.prj.common.Command;
import co.nambaone.prj.user.service.UserService;
import co.nambaone.prj.user.serviceImpl.UserServiceImpl;

public class AjaxuserIdCheck implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 아이디 중복체크를 Ajax로 처리
		UserService dao = new UserServiceImpl();
		String id = request.getParameter("userEmail");
		String result = "1"; // 존재하지 않으면 1 -> 사용 가능 하다는 말
		boolean b = dao.isIdCheck(id);
		if (!b) {
			result = "0";
		}
		
		return "Ajax:" + result;
	}

}
