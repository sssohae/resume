package co.nambaone.prj.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	//수행해서 결과페이지를 찾아준다. 결과페이지는 string이니까 string으로 적어주는것
	String exec(HttpServletRequest request, HttpServletResponse response);
}
