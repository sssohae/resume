package co.nambaone.prj.user.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.nambaone.prj.common.Command;
import co.nambaone.prj.user.service.UserService;
import co.nambaone.prj.user.service.UserVO;
import co.nambaone.prj.user.serviceImpl.UserServiceImpl;


public class UserSelect implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 회원 한명 조회
		UserService dao = new UserServiceImpl();
		UserVO vo = new UserVO();
		
		vo.setUserEmail(request.getParameter("userEmail"));
		vo = dao.userSelect(vo);
		
		String viewPage = null;
		
		if(vo != null) {
			request.setAttribute("member", vo);
			viewPage = "user/userSelect.tiles";
		}else {
			request.setAttribute("message", "존재하지 않는 회원입니다.");
			viewPage = "user/myPage.tiles";
		}
			
		return viewPage;
	

}
}
