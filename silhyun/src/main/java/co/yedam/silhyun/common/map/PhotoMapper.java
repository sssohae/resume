package co.yedam.silhyun.common.map;

import java.util.List;

import co.yedam.silhyun.common.vo.PhotoVO;

public interface PhotoMapper {
	List<PhotoVO> photoList(PhotoVO vo);
	int photoInsert(PhotoVO vo);
	int photoDelete(PhotoVO vo);
	
	int ptgRegiInsert(PhotoVO vo);
	
	//찐으로 지우는거
	int photoAllDelete();
}
