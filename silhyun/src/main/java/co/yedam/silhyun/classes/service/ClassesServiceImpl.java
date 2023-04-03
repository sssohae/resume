package co.yedam.silhyun.classes.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.yedam.silhyun.classes.map.ClassesMapper;
import co.yedam.silhyun.classes.vo.ClassesVO;
import co.yedam.silhyun.classes.vo.InetClassesWtchVO;
import co.yedam.silhyun.common.vo.ZzimVO;

@Service
public class ClassesServiceImpl implements ClassesService {


	@Autowired ClassesMapper ClassesMapper;
	
	
	//인강리스트
	@Override
	public List<Map<String, Object>> getC1List() {
		return ClassesMapper.getC1List();
	}

	//현강리스트
	@Override
	public List<Map<String, Object>> getC2List() {
		return ClassesMapper.getC2List();
	}

	
	
	//클래스의 해당 인강정보
	@Override
	public List<Map<String, Object>> getClassIVInfo(String id, String classNum) {
		return ClassesMapper.getClassIVInfo(id, classNum);
	}
	
	//인강 상세정보
	@Override
	public Map<String, Object> selectIV(String classNum, String inetNum, String id) {
		return ClassesMapper.selectIV(classNum, inetNum, id);
	}
	
	//인강 시청기록삽입
	@Override
	public int insertWInfo(InetClassesWtchVO vo) {
		return ClassesMapper.insertWInfo(vo);
	}
	
	
	
	//베스트 무료강의 페이지
	@Override
	public List<Map<String, Object>> getBCList() {
		return ClassesMapper.getBCList();
	}
	
	//무료강의 페이지
	@Override
	public List<Map<String, Object>> getFCList() {
		return ClassesMapper.getFCList();
	}
	
	
	
	//조건에 맞는 인강리스트 아작스
	@Override
	public List<Map<String, Object>> cdtC1List(int param1) {
		return ClassesMapper.cdtC1List(param1);
	}

	@Override
	public List<Map<String, Object>> cdtC2List(int param1) {
		return ClassesMapper.cdtC2List(param1);
	}
	
	
	
	//클래스 상세정보
	@Override
	public ClassesVO selectClass(java.lang.String classNum) {
		return ClassesMapper.selectClass(classNum);
	}
	
	//클래스 상세정보와 함께 보낼 부가 정보
	@Override
	public Map<String, Object> CPlusInfo(String classNum) {
		return ClassesMapper.CPlusInfo(classNum);
	}
	
	//클래스 상세정보와 함께 보낼 회원관련 부가 정보
	@Override
	public Map<String, Object> CMPlusInfo(String classNum, String id) {
		return ClassesMapper.CMPlusInfo(classNum, id);
	}
	
	//클래스 상세정보페이지에서 함께 보여줄 랜덤리스트
	@Override
	public List<Map<String, Object>> randomList(String classNum) {
		return ClassesMapper.randomList(classNum);
	}
	
	
	
	//내 수강강의 페이지. 회원 이름 가져오기
	@Override
	public String getName(String id) {
		return ClassesMapper.getName(id);
	}
	
	//내가 수강중인 인강리스트
	@Override
	public List<Map<String, Object>> myTakeC1(String id) {
		return ClassesMapper.myTakeC1(id);
	}
	
	@Override
	public List<Map<String, Object>> myTakeC2(String id) {
		return ClassesMapper.myTakeC2(id);
	}

	//내 수강중인 현강 세부정보 아작스
	@Override
	public Map<String, Object> myC1Ajax(String classNum) {
		return ClassesMapper.myC1Ajax(classNum);
	}

	
	
	//찜
	@Override  //찜 확인
	public boolean cIsZzim(ZzimVO vo) {
		int count = ClassesMapper.cFindZzim(vo);
		return count > 0;
	}
	@Override  //찜 추가
	public void cInsertZzim(ZzimVO vo) {
		ClassesMapper.cInsertZzim(vo);
	}
	@Override //찜 삭제
	public void cDelZzim(ZzimVO vo) {
		ClassesMapper.cDelZzim(vo);
	}

}
