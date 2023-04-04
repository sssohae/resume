package co.nambaone.prj.user.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.nambaone.prj.common.Command;
import co.nambaone.prj.user.service.UserService;
import co.nambaone.prj.user.service.UserVO;
import co.nambaone.prj.user.serviceImpl.UserServiceImpl;

public class UserList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 회원 전체목록
		UserService dao = new UserServiceImpl();
		List<UserVO> members = new ArrayList<UserVO>();
		
		members = dao.userSelectList(); //db에서 멤버테이블의 목록 가져오기
		request.setAttribute("members", members);
		return null; // 이후에 '관리자' 회원목록에서 확인해보기
	}

}
