package co.nambaone.prj.user.command;


import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.nambaone.prj.common.Command;

public class MyPage implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		
		

		
		HttpSession session = request.getSession();
		String message = (String) session.getAttribute("Nickname");
		request.setAttribute("message", message);	
		
		String message2 =(Date) session.getAttribute("joinDate") + "부터 함께";
		request.setAttribute("message2", message2);			
		
		
		
		
		
//		String message2 = (String)session.getAttribute("userEmail");
//		request.setAttribute("message2", message2);	
		
//		UserService dao = new UserServiceImpl();
//		UserVO vo = new UserVO();
//		HttpSession session = request.getSession();
//		
//		String message = null;
//		vo.setUserEmail((String)session.getAttribute("userEmail"));
//		System.out.println((String)session.getAttribute("userEmail"));
//		
//		vo = dao.userSelect(vo);
//		if(vo != null) {
//			session.setAttribute("id", vo.getUserEmail());
//			session.setAttribute("Nickname", vo.getUserNickname());
//			
//			message = vo.getUserNickname();
// 
//			request.setAttribute("message", message);
//
//		}
		
		return "user/myPage.tiles";
	}

}
