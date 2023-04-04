package co.nambaone.prj.movie.service;

import java.util.List;

public interface MovieService {
	
	//관리자용 movie관리(등록 삭제 수정 읽기  curd)
	List<MovieVO> willInsert(MovieVO vo);//근데 왠지 api에서 바로 가져오면 될 것 가타수,,,없어도 될 덧 나중에 검토하고 뺴든지 말든지
	List<MovieVO> insertedSelect(MovieVO vo);//등록한 영화//db들어가잇는 것 보여주기
	
	int movieUpdate(MovieVO vo);//영화수정
	int movieInsert(MovieVO vo);//단일등록
	int movieDelete(MovieVO vo);//영화 삭제
	
	//등록안한것중에 검색하기....
	//등록한 것 중에 검색하기.....
	
	

}
