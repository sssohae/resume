package co.nambaone.prj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.nambaone.prj.admin.command.AdminMain;
import co.nambaone.prj.admin.command.Report;
import co.nambaone.prj.common.Command;
import co.nambaone.prj.movie.command.Categories;
import co.nambaone.prj.movie.command.Jjim;
import co.nambaone.prj.movie.command.MainCommand;
import co.nambaone.prj.movie.command.NewMovie;
import co.nambaone.prj.movie.command.movieDetail;
import co.nambaone.prj.movie.command.movieWatching;

import co.nambaone.prj.notice.command.NoticeDelete;
import co.nambaone.prj.notice.command.NoticeEdit;
import co.nambaone.prj.notice.command.NoticeEditForm;
import co.nambaone.prj.notice.command.NoticeInsert;
import co.nambaone.prj.notice.command.NoticeInsertForm;
import co.nambaone.prj.notice.command.NoticeList;
import co.nambaone.prj.notice.command.NoticeSelect;

import co.nambaone.prj.user.command.UserUpdateAjax;
import co.nambaone.prj.user.command.AjaxuserIdCheck;
import co.nambaone.prj.user.command.FindPw;
import co.nambaone.prj.user.command.MyPage;
import co.nambaone.prj.user.command.PwCheck;
import co.nambaone.prj.user.command.PwCheckForm;
import co.nambaone.prj.user.command.UserAjax;
import co.nambaone.prj.user.command.UserJoin;
import co.nambaone.prj.user.command.UserJoinForm;
import co.nambaone.prj.user.command.UserList;
import co.nambaone.prj.user.command.UserLogin;
import co.nambaone.prj.user.command.UserLoginForm;
import co.nambaone.prj.user.command.UserLogout;
import co.nambaone.prj.user.command.UserSearchAjax;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// HashMap : 아래의 command 명령집단을 담을수 있게 적어준것
	private HashMap<String, Command> map = new HashMap<String, Command>();

	public FrontController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		// 명령집단 map.put(k,v) 을 보관하는곳
		//영화
		map.put("/main.do", new MainCommand()); // 메인 페이지
		map.put("/categories.do", new Categories());	//영화 카테고리
		map.put("/jjim.do", new Jjim());	//찜 화면
		map.put("/movieDetail.do", new movieDetail());	//영화정보 상세보기
		map.put("/movieWatching.do", new movieWatching());	//영화 재생화면
		map.put("/newMovie.do", new NewMovie());	//새로운 영화
		
		//관리자
		map.put("/adminMain.do", new AdminMain());	//관리자 메인페이지
		map.put("/report.do", new Report());	//신고내역 페이지
		map.put("/userList.do", new UserList()); // 회원 전체목록
		
		map.put("/noticeInsertForm.do", new NoticeInsertForm());//공지사항 등록 폼
		map.put("/noticeList.do", new NoticeList()); //공지사항 목록
		map.put("/noticeSelect.do", new NoticeSelect()); //공지사항 상세보기
		map.put("/noticeInsert.do", new NoticeInsert());//공지사항 등록
		map.put("/noticeEditForm.do",new NoticeEditForm()); //공지사항 수정폼
		map.put("/noticeEdit.do", new NoticeEdit()); //공지사항 수정
		map.put("/noticeDelete.do", new NoticeDelete()); //공지사항 삭제
		
		//유저
		map.put("/myPage.do", new MyPage()); //마이페이지
		map.put("/userJoin.do", new UserJoin()); // 회원가입 처리
		map.put("/userJoinForm.do", new UserJoinForm()); // 회원가입 폼(signUp.jsp랑 연결)
		map.put("/ajaxuserIdCheck.do", new AjaxuserIdCheck()); // 이메일(id) 중복 체크
		map.put("/userLogin.do", new UserLogin()); // 로그인 처리
		map.put("/userLoginForm.do", new UserLoginForm()); // 로그인 폼(login.jsp랑 연결)
		map.put("/userLogout.do", new UserLogout()); // 로그아웃 처리
		map.put("/findPw.do", new FindPw());

		map.put("/userAjax.do", new UserAjax());
		map.put("/userUpdateAjax.do", new UserUpdateAjax());
		map.put("/userSearchAjax.do", new UserSearchAjax());
		map.put("/pwCheck.do", new PwCheck());
		map.put("/pwCheckForm.do", new PwCheckForm());
		
//		map.put("/ckedit.do", new Ckedit());
//		map.put("/fileupload.do", new FileUpload());
//		map.put("/insertText.do", new InsertText());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 요청을 분석, 실행, 결과를 돌려주는곳
		request.setCharacterEncoding("utf-8"); // 한글깨짐방지
		String uri = request.getRequestURI(); // 1. uri값을 읽어온다
		String contextPath = request.getContextPath(); // 2. 그 중에서 ContextPath를 읽어온다
		String page = uri.substring(contextPath.length()); // 3. 실제 요청명(index.jsp)을 읽어내기 위해 uri에서 contextPath만큼의 길이를 뺀
															// 위치부터 헤아린다.

		Command command = map.get(page); // map안의 키 값을 command로 찾고
		String viewPage = command.exec(request, response); // 찾은 Command를 실행시켜서 그 결과를 받고

		// <view resolve start> (그 결과를 어떤 페이지에 뿌려줄것인가)
		if (!viewPage.endsWith(".do")) { // viewpage가 .do로 끝나지 않는다면
			if (viewPage.startsWith("Ajax:")) { // ajax로 시작하는지 확인
				// ajax
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().print(viewPage.substring(5));// Ajax: <-(총 5자) 뒤부터 헤아려서 쓰라는거임
				return;
			} else if (!viewPage.endsWith(".tiles")) {
				viewPage = "WEB-INF/views/" + viewPage + ".jsp"; // 타일즈 적용 안하는것
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect(viewPage);
		}
		// <view resolve end>

	}

}
