package co.nambaone.prj.user.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.nambaone.prj.common.Command;

public class UserAjax implements Command {

		@Override
		public String exec(HttpServletRequest request, HttpServletResponse response) {
			// TODO Auto-generated method stub
			return "user/userAjax.tiles";
		}

	}
