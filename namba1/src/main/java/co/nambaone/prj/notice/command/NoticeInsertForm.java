package co.nambaone.prj.notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.nambaone.prj.common.Command;

public class NoticeInsertForm implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "notice/noticeInsertForm.tiles";

//		return "notice/ckEdit.tiles";
	}

}
