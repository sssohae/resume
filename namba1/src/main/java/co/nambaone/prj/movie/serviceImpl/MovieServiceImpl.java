package co.nambaone.prj.movie.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.nambaone.prj.common.DataSource;
import co.nambaone.prj.movie.map.MovieMapper;
import co.nambaone.prj.movie.service.MovieService;
import co.nambaone.prj.movie.service.MovieVO;

public class MovieServiceImpl implements MovieService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private MovieMapper map = sqlSession.getMapper(MovieMapper.class);

	
	//관리자용 movie관리(등록 삭제 수정 읽기  curd)
	@Override
	public List<MovieVO> willInsert(MovieVO vo) {//근데 왠지 api에서 바로 가져오면 될 것 가타수,,,없어도 될 덧 나중에 검토하고 뺴든지 말든지
		// TODO Auto-generated method stub
		return map.willInsert(vo);
	}

	@Override
	public List<MovieVO> insertedSelect(MovieVO vo) {//등록한 영화//db들어가잇는 것 보여주기
		// TODO Auto-generated method stub
		return map.insertedSelect(vo);
	}

	@Override
	public int movieUpdate(MovieVO vo) {//영화수정
		// TODO Auto-generated method stub
		return map.movieUpdate(vo);
	}

	@Override
	public int movieInsert(MovieVO vo) {//등록
		// TODO Auto-generated method stub
		return map.movieInsert(vo);
	}

	@Override
	public int movieDelete(MovieVO vo) {//영화 삭제
		// TODO Auto-generated method stub
		return map.movieDelete(vo);
	}

	//등록안한것중에 검색하기....
	//등록한 것 중에 검색하기.....
	

}
