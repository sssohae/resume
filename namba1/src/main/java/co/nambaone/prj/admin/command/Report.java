package co.nambaone.prj.admin.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.nambaone.prj.common.Command;

public class Report implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 신고내역
		return "admin/report.tiles"; 

	}

}
