package co.nambaone.prj.user.command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.nambaone.prj.common.Command;
import co.nambaone.prj.user.service.UserService;
import co.nambaone.prj.user.service.UserVO;
import co.nambaone.prj.user.serviceImpl.UserServiceImpl;

public class PwCheck implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		UserService dao = new UserServiceImpl();
		UserVO vo = new UserVO();
		HttpSession session = request.getSession();

		vo.setUserPassword(request.getParameter("userPassword"));

		vo.setUserEmail((String) session.getAttribute("userEmail"));

		System.out.println("emal=" + vo.getUserEmail());
		System.out.println("pw=" + vo.getUserPassword());

		vo = dao.userSelect(vo);
		

		if (vo != null) {


		} else {

		    try {
		        response.setContentType("text/html; charset=utf-8");
		        PrintWriter w = response.getWriter();
		        w.write("<script>alert('잘못된 비밀번호입니다.');location.href='myPage.do';</script>");
		        w.flush();
		        w.close();
		    } catch(Exception e) {
		        e.printStackTrace();
		    }
		    return request.getContextPath() + "/myPage.do";


		}
		return request.getContextPath() + "/userAjax.do";

	}

}