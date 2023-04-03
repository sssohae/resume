package co.yedam.silhyun.classes.service;

import java.util.List;
import java.util.Map;

import co.yedam.silhyun.classes.vo.ClassesVO;
import co.yedam.silhyun.classes.vo.InetClassesWtchVO;
import co.yedam.silhyun.common.vo.ZzimVO;

public interface ClassesService {

	
	//인강리스트 
	List<Map<String, Object>> getC1List(); 
	
	//현강리스트
	List<Map<String, Object>> getC2List(); 
	
	
	
	//조건에 맞는 인강리스트 아작스 
	List<Map<String, Object>> cdtC1List(int param1); 
	
	List<Map<String, Object>> cdtC2List(int param1);
	
	
	
	//베스트 무료강의 페이지
	List<Map<String, Object>> getBCList();
	
	//무료강의 페이지
	List<Map<String, Object>> getFCList(); 
	
	
	
	//클래스 상세정보
	ClassesVO selectClass(String classNum);
	
	//클래스 상세정보와 함께 보낼 부가 정보
	Map<String, Object> CPlusInfo(String classNum);
	
	//클래스 상세정보와 함께 보낼 회원관련 부가 정보
	Map<String, Object> CMPlusInfo(String classNum, String id);
	
	//클래스 상세정보페이지에서 함께 보여줄 랜덤리스트
	List<Map<String, Object>> randomList(String classNum);
	
	
	
	//내 수강강의 페이지. 회원 이름 가져오기
	String getName(String id);
	
	//내가 수강중인 인강리스트
	List<Map<String, Object>> myTakeC1(String id);
	
	//내가 수강중인 현강리스트
	List<Map<String, Object>> myTakeC2(String id);

	//내 수강강의 오프라인 세부 아작스 
	Map<String, Object> myC1Ajax(String classNum);
	
	
	
	//클래스의 해당 인강정보
	List<Map<String, Object>> getClassIVInfo(String id, String classNum); 

	//인강 상세정보
	Map<String, Object> selectIV(String classNum, String inetNum, String id);
	
	//인강 시청기록삽입
	int insertWInfo(InetClassesWtchVO vo);

	
	
	//찜
	boolean cIsZzim(ZzimVO vo);  //찜 데이터 있는지 확인
	void cInsertZzim(ZzimVO vo); // 찜 추가하기
	void cDelZzim(ZzimVO vo); //찜 삭제하기
	
}
