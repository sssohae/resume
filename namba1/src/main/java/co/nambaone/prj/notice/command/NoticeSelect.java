package co.nambaone.prj.notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import co.nambaone.prj.common.Command;
import co.nambaone.prj.notice.service.NoticeService;
import co.nambaone.prj.notice.service.NoticeVO;
import co.nambaone.prj.notice.serviceImpl.NoticeServiceImpl;

public class NoticeSelect implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		NoticeService dao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		
		vo.setNoticeId(Integer.valueOf(request.getParameter("noticeId")));
		vo = dao.noticeSelect(vo);
		request.setAttribute("notice", vo);
		return "notice/noticeSelect.tiles";
	}

}