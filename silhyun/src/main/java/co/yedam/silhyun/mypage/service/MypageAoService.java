package co.yedam.silhyun.mypage.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import co.yedam.silhyun.classes.vo.ClassesVO;
import co.yedam.silhyun.common.vo.Criteria;
import co.yedam.silhyun.event.vo.CouponVO;
import co.yedam.silhyun.event.vo.EventVO;
import co.yedam.silhyun.member.vo.MemberVO;
import co.yedam.silhyun.member.vo.OptionsVO;
import co.yedam.silhyun.member.vo.PhotographerVO;
import co.yedam.silhyun.member.vo.ReserTimeVO;
import co.yedam.silhyun.order.vo.ReserVO;

public interface MypageAoService {
	int getReserList(String ptgId);//예약전체조회 페이징
	List<ReserVO> selectReserList(String ptgId, Criteria cri);//예약조회
	int totalClassList(String ptgId);//클래스조회 페이징
	List<ClassesVO> classList(String ptgId, Criteria cri);//클래스 관리 정보 
	
	List<MemberVO> getPhotoinfo(String id); //포토그래퍼 조회
	MemberVO ptgSelect(MemberVO vo);//회원+작가 한명 조회
	List<PhotographerVO> getPtg(String ptgId);//작가에서만 한명
	
	PhotographerVO selectWorkDay(String ptgId);	//workday출력용
	List<ReserTimeVO> ptgRestime(String ptgId) ;//근무 시간 출력용
	
	int ptgInfoUpdate(MemberVO vo);	//정보 업데이트
	int updateWorkday(PhotographerVO vo);	//정보중 근무요일 업데이트
	
	int applyEvent(EventVO vo);	//이벤트 신청
	int applyECoupon(CouponVO vo);	//이벤트 신청 쿠폰부분
	int applyClass(ClassesVO vo); 	//클래스 신청
	int insertOption(OptionsVO vo);	//작가 옵션설정
	
	int updateReserTime(List<ReserTimeVO> voList);	//작가 예약시간 수정설정
	int updateReserTime(ReserTimeVO vo);	//작가 예약시간 수정

	int deleteReserTime(String id);	// 작가 예약시간정보 삭제
	int insertReserTime(ReserTimeVO vo );	//작가 예약시간 정보 삽입
	
	List<PhotographerVO> getResTime(String ptgId,String redate);//작가예약옵션 호출
	
	//클래스 수강자조회
	List<MemberVO> getInquiryC();
	
	//캘린더
	List<PhotographerVO> getResInfo(String ptgId,String redate, String shotTime);
	
	List<MemberVO> clMemInfo(String classNum);	//클래스 수강조회 멤버 정보
	int uploadPhoto(ReserVO vo);			//대표사진설정

	
}
