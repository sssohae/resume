package co.nambaone.prj.user.serviceImpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import co.nambaone.prj.common.DataSource;
import co.nambaone.prj.user.map.UserMapper;
import co.nambaone.prj.user.service.UserService;
import co.nambaone.prj.user.service.UserVO;

public class UserServiceImpl implements UserService {
	//true를 쓰지 않으면 오토커밋이 되질 않음.
	SqlSession sqlSession = DataSource.getInstance().openSession(true); // 데이터베이스연걸
	UserMapper map = sqlSession.getMapper(UserMapper.class); //구연체랑 sqlsession을 통해 MemberMapper class를 넣어줌
	@Override
	public List<UserVO> userSelectList() {
		// 회원목록 보기(관리자)
		return map.userSelectList();
	}

	@Override
	public int userInsert(UserVO vo) {
		// 회원정보 입력
		return map.userInsert(vo);
	}

	@Override
	public UserVO userSelect(UserVO vo) {
		// 회원정보 조회
		return map.userSelect(vo);
	}
	
	@Override
	public int userDelete(UserVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int userUpdate(UserVO vo) {
		// TODO Auto-generated method stub
		return map.userUpdate(vo);
	}

	@Override
	public boolean isIdCheck(String id) {
		return map.isIdCheck(id);
	}

	@Override
	public List<Map<String, Integer>> chartLine() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Integer>> chartDonut() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findPw(UserVO vo) {
		// 비밀번호 찾기
		return map.findPW(vo);
	}

	@Override
	public int countNotice() {
		// TODO Auto-generated method stub
		return map.countNotice();
	}

	
}
