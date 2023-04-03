package co.yedam.silhyun;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import co.yedam.silhyun.member.vo.UserVO;

@Service
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Autowired HttpSession session;
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		    request.getSession().setAttribute("id", authentication.getName());
			request.getSession().setAttribute("role", authentication.getAuthorities());

		response.sendRedirect("/");

	}

}
