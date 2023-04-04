package co.nambaone.prj.user.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.nambaone.prj.common.Command;
import co.nambaone.prj.user.service.UserService;
import co.nambaone.prj.user.service.UserVO;
import co.nambaone.prj.user.serviceImpl.UserServiceImpl;

public class FindPw implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 비밀번호 찾기
		UserService dao = new UserServiceImpl();
		UserVO vo = new UserVO();
		String email = request.getParameter("userEmail");
		
		int pw = 0;
		vo.setUserEmail(email);
		//vo.setUserPassword("userPassword");
		
		pw = dao.findPw(vo);
		
		System.out.println(pw + "============");
				
		request.setAttribute("pw", pw);
		if(pw == 0) {
			return "user/findPw.tiles";
		}
		return "movie/main.tiles";
	}

}
