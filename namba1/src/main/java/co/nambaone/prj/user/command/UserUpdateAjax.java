package co.nambaone.prj.user.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.nambaone.prj.common.Command;
import co.nambaone.prj.user.service.UserService;
import co.nambaone.prj.user.service.UserVO;
import co.nambaone.prj.user.serviceImpl.UserServiceImpl;

public class UserUpdateAjax implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
	
	
		HttpSession session = request.getSession(); 
		UserVO vo = new UserVO();
		
		
		UserService dao = new UserServiceImpl();

		vo.setUserEmail(request.getParameter("userEmail"));
		vo.setUserPassword(request.getParameter("userPassword"));
		vo.setUserTel(request.getParameter("userTel"));
		vo.setCardNumber(request.getParameter("cardNumber"));
		

		int n = dao.userUpdate(vo);
		
		String json = null;
		ObjectMapper mapper = new ObjectMapper();

		if (n > 0) {
			vo = dao.userSelect(vo); // 수정처리 후 ajax 응답에 id와 관련된 모든 정보를 넘겨줌.
			try {
				json = mapper.writeValueAsString(vo);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			session.setAttribute("cardNumber", vo.getCardNumber());
			session.setAttribute("userPassword", vo.getUserPassword());
			session.setAttribute("userTel", vo.getUserTel());
			
			return "Ajax:" + json;
		}
		return "Ajax:" + "{\"retCode\":\"Fail\"}";
	}

}
	
