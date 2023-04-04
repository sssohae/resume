package co.nambaone.prj.user.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.nambaone.prj.common.Command;
import co.nambaone.prj.user.service.UserService;
import co.nambaone.prj.user.service.UserVO;
import co.nambaone.prj.user.serviceImpl.UserServiceImpl;

public class UserSearchAjax implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		UserService dao = new UserServiceImpl();
		UserVO vo = new UserVO();

		vo.setUserEmail(request.getParameter("userEmail"));
		vo = dao.userSelect(vo);

		String json = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			json = mapper.writeValueAsString(vo);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return "Ajax:" + json;
	}

}
