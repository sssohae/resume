package co.nambaone.prj.user.map;

import java.util.List;

import co.nambaone.prj.user.service.UserVO;

public interface UserMapper {
	List<UserVO> userSelectList(); // 회원 전체조회
	UserVO userSelect(UserVO vo); // 회원 유무조회
	int userInsert(UserVO vo); //입력
	int userDelete(UserVO vo); //삭제
	int userUpdate(UserVO vo); //수정
	int findPW(UserVO vo); // 비밀번호 찾기
	int accounntUpdate(UserVO vo);
	int countNotice();
	
	boolean isIdCheck(String id); // 아이디 중복체크 존재하면 false

}
