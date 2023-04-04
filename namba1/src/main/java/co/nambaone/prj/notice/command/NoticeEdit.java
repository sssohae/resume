package co.nambaone.prj.notice.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


import co.nambaone.prj.common.Command;
import co.nambaone.prj.notice.service.NoticeService;
import co.nambaone.prj.notice.service.NoticeVO;
import co.nambaone.prj.notice.serviceImpl.NoticeServiceImpl;

public class NoticeEdit implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 공지사항 수정
		NoticeService dao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		String saveDir = request.getServletContext().getRealPath("/attech/");  //현재 프로젝트 디렉토리로 

		int maxSize = 1024*1024*1024;  //최대 10M까지 업로드
		
		try {
			MultipartRequest multi = new MultipartRequest( //파일을 업로드시 request객체를 대체한다. 
						request, saveDir, maxSize, "utf-8",
						new DefaultFileRenamePolicy());
			
			vo.setNoticeId(Integer.valueOf(multi.getParameter("noticeId")));
			//vo.setNoticeDate(Date.valueOf(multi.getParameter("noticeDate")));
			vo.setNoticeTitle(multi.getParameter("noticeTitle"));
			vo.setNoticeSubject(multi.getParameter("noticeSubject"));
			
			String ofileName = multi.getOriginalFileName("nfile");
			String pfileName = multi.getFilesystemName("nfile");
			
			if(ofileName != "") {
				vo.setNoticeFile(ofileName);
				pfileName = saveDir + pfileName; //저장directory 와 저장명
				vo.setNoticeFileDir(pfileName);
			}
			
			int n = dao.noticeUpdate(vo);
			if(n != 0) {
				response.setContentType("text/html; charset=UTF-8");
				 
				PrintWriter out = response.getWriter();
				 
				out.println("<script>alert('수정되었습니다.'); location.href='noticeList.do';</script>");
				 
				out.flush();
			} else {
				request.setAttribute("message", "공지사항이 수정실패했습니다.");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return request.getContextPath()+"/noticeList.do";
	}

}
