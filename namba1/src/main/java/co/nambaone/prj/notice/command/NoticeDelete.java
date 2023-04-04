package co.nambaone.prj.notice.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.nambaone.prj.common.Command;
import co.nambaone.prj.notice.service.NoticeService;
import co.nambaone.prj.notice.service.NoticeVO;
import co.nambaone.prj.notice.serviceImpl.NoticeServiceImpl;



public class NoticeDelete implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 공지사항 삭제
		NoticeService dao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		vo.setNoticeId(Integer.valueOf(request.getParameter("noticeId")));
		int n = dao.noticeDelete(vo);
		if (n != 0) {

			try {
			response.setContentType("text/html; charset=UTF-8");
	
			PrintWriter out = response.getWriter();
			 
			out.println("<script>alert('공지사항이 삭제되었습니다.'); location.href='noticeList.do';</script>");
			 
			out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			
			try {
			response.setContentType("text/html; charset=UTF-8");
			 
			PrintWriter out = response.getWriter();
			 
			out.println("<script>alert('공지사항이 삭제실패했습니다.'); location.href='noticeList.do';</script>");
			 
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}		
	return request.getContextPath() + "/noticeList.do";
}

}
