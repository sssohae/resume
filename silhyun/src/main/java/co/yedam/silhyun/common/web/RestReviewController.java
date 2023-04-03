package co.yedam.silhyun.common.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import co.yedam.silhyun.common.service.PhotoService;
import co.yedam.silhyun.common.service.ReviewService;
import co.yedam.silhyun.common.vo.PhotoVO;
import co.yedam.silhyun.common.vo.ReviewVO;
import co.yedam.silhyun.order.vo.PaymentVO;

@RestController
public class RestReviewController {
	@Autowired ReviewService rService;
	@Autowired PhotoService pService;
	
	@PostMapping("/silhyun/review")
	public ReviewVO reviewInsert(ReviewVO vo, List<MultipartFile> files) {  //@RequestParam => 필수값임
		String ctgrNum = rService.reviewInsert(vo);
		String ctgr = "R";
		pService.photoInsert(files, ctgrNum, ctgr);
		return vo;
	}

	
	@PostMapping("/silhyun/getPhoto")
	public List<PhotoVO> getPhoto(PhotoVO vo) {
		List<PhotoVO> list = new ArrayList<PhotoVO>();
		list = pService.photoList(vo);
		return list;
	}
	
	@GetMapping("/silhyun/reviewUpdate")
	public Map<String, Object> selectReview(String revNum, ReviewVO vo, PhotoVO pvo){
		vo.setRevNum(revNum);
		Map<String, Object> map = new HashMap<String, Object>();
		vo = rService.reivewSelect(vo);
		map.put("rev", vo);
		pvo = new PhotoVO();
		pvo.setCtgr("R");
		pvo.setCtgrNum(vo.getRevNum());
		map.put("pho", pService.photoList(pvo));
		PaymentVO payVo = new PaymentVO();
		payVo.setOrdNum(vo.getOrdNum());
		payVo.setCtgr(vo.getCtgr());
		map.put("ord", rService.selectPayInfo(payVo));
		
		return map;
	}
	@PostMapping("/silhyun/update")
	public ReviewVO updateReview(PhotoVO pvo, ReviewVO rvo, List<MultipartFile> files) {
		//리뷰 업댓

		rService.reviewUpdate(rvo);
		//삭제할 사진 	
		if(pvo.getPhoNum().length()>0) {
			String[] ary = pvo.getPhoNum().split(",");
			for(String id : ary) {
				System.out.println(id);
				pvo.setPhoNum(id);
				pService.photoDelete(pvo);	
			}	
		}
		//사진 업댓
		String ctgrNum = rvo.getRevNum(); 
		String ctgr = "R";
		pService.photoInsert(files, ctgrNum, ctgr);
		return rvo;
	}
	
	@GetMapping("/reviewDel")
	public String reviewDelete(ReviewVO vo) {
		//파일삭제
		PhotoVO pvo = new PhotoVO();
		pvo.setCtgr("R");
		pvo.setCtgrNum(vo.getRevNum());
		System.out.println(pvo);
	    pService.photoDelete(pvo);
	    //리뷰삭제
	    rService.reviewDelete(vo);
		
		return "del";
	}
	
	//리뷰작성 체크
	@GetMapping("/insertChek")
	public int insertCheck(PaymentVO vo) {
		int n = 0;
		n = rService.isReviewCheck(vo);
		
		return n;
	}
	
	//주문정보
	@GetMapping("/ordInfoAtt")
	public List<ReviewVO> ordInfoAtt(PaymentVO vo) {
		List<ReviewVO> list = rService.selectPayInfo(vo);
		
		return list;
	}
}
