package co.yedam.silhyun.common.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import co.yedam.silhyun.common.vo.PhotoVO;

public interface PhotoService {
	List<PhotoVO> photoList(PhotoVO vo);
	int photoInsert(List<MultipartFile> files, String ctgrNum, String ctgr);
	//사진 uesd 수정하는거
	int photoDelete(PhotoVO vo);
	
	int ptgRegiInsert(List<MultipartFile> files, String ctgrNum, String ctgr);
	
	//찐으로 지우는거
	int photoAllDelete();
}
