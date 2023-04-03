package co.yedam.silhyun.member.service;

import java.util.List;
import java.util.Map;

import co.yedam.silhyun.event.vo.EventVO;
import co.yedam.silhyun.member.vo.AdminCriteria;
import co.yedam.silhyun.member.vo.MemberVO;
import co.yedam.silhyun.member.vo.PhotographerVO;
import co.yedam.silhyun.member.vo.StudioVO;
import co.yedam.silhyun.mypage.vo.QuitVO;

public interface AdminSercive {

	//대시보드 =========================================
	//승인 대기 count
	Map<String, Object> cfmCnt();

	//지난 2주간 매출
	List<Map<String, Object>> lastSales();
	
	//최신 결제 5건
	List<Map<String, Object>> recentBuy();
	
	//최신 댓글 3건
	List<Map<String, Object>> recentCom();
	
	//최신 가입 5건
	List<MemberVO> recentJoin();
	
	//기록가 분야 통계 
	List<Map<String, String>> ptgGraph();
	
	//랭킹
	List<Map<String, Object>> ptgRank();
	
	List<Map<String, Object>> classRank();
	
	
	
	//전체 회원관리 =========================================
	//회원리스트
	List<MemberVO> memberList();
	
	//회원정보 수정
	int updateMember(MemberVO vo);
	
	//기록가리스트
	List<Map<String, Object>> ptgList();
	
	//사진관리스트 
	List<StudioVO> stdList();
	
	//사진관의 소속작가
	List<PhotographerVO> belongPtg(String stId);
	
	//오늘 가입 회원 count
	List<MemberVO> todayMem();
	
	//오늘 가입 회원 count
	List<MemberVO> todayPtg();
	
	List<MemberVO> todayStd();
	
	//회원 비활성화
	int disableMember(String id);
	
	//회원 활성화
	int ableMember(String id);

	
	
	//종합승인관리 =========================================
	//승인신청 카운트
	Map<String, Object> countNeedCfm();
	
	
	//기록가 승인관리
	List<Map<String, Object>> ptgCfmList();
	
	//기록가 승인상세정보
	Map<String, Object> ptgSelect(String ptgId);
	
	//기록가 승인신청 승인
	int ptgAccept(String ptgId);
	
	//기록가 승인신청 반려
	int noPtgAccept(String ptgId);
	
	
	//사진관 승인관리
	List<Map<String, Object>> stdCfmList();
	
	//사진관 승인상세정보
	Map<String, Object> stdSelect(String stId);
	
	
	//사진관 승인신청
	List<Map<String, Object>>getEventOList();
	
	//사진관 승인신청 승인
	int stdAccept(String stId);
	
	//사진관 승인신청 반려
	int noStdAccept(String stId);

	
	//클래스 승인관리
	List<Map<String, Object>> classCfmList();
	
	//클래스 승인상세정보
	Map<String, Object> classSelect(String classNum);
	
	//클래스 승인신청 승인
	int classAccept(String classNum);
	
	//클래스 승인신청 반려
	int noClassAccept(String classNum);
	
	
	//이벤트 승인신청 승인
	int eventAccept(String eventNum);
	
	//이벤트 승인신청 반려
	int noEventAccept(String eventNum);
		
	
	
	//이벤트 =========================================	
	//이벤트 count
	Map<String, String> getEventCnt();

	//이벤트리스트
	List<Map<String, Object>>getEventList();
	
	//이벤트리스트 종료포함 
	List<Map<String, Object>>getEventAllList();
		
	//이벤트 상세정보
	EventVO getEventContent(String eventNum);

	

	//탈퇴 계정관리 =========================================
	//탈퇴회원 리스트
	List<QuitVO> qtList();
	
	//탈퇴회원 리스트 페이징
	List<Map<String, Object>> getListQuit(AdminCriteria cri);
	
	//탈퇴회원 count. 
	int getTotalQuit(AdminCriteria cri);
	

	
	//관리자 계정관리 =========================================	
	//관리자 정보
	MemberVO adminInfo();
	
	//관리자 정보수정
	int updateAdmin(MemberVO vo);

	//탈퇴통계 그래프
	List<Map<String, String>> quitGraph();
	
	
	
	//페이징 =========================================
	//회원리스트 페이징
	List<MemberVO> getListMember(AdminCriteria cri);
	
	int getTotalCount(AdminCriteria cri);

	//작가리스트 페이징
	List<Map<String, Object>> getListPtg(AdminCriteria cri2);
	
	int getTotalPtg(AdminCriteria cri2);
	
	//사진관리스트 페이징
	List<Map<String, Object>> getListStd(AdminCriteria cri3);
	
	int getTotalStd(AdminCriteria cri3);


}
