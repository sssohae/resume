package co.yedam.silhyun.order.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.yedam.silhyun.classes.service.ClassesService;
import co.yedam.silhyun.common.vo.ZzimVO;
import co.yedam.silhyun.member.service.PtgService;

@Controller
public class ZzimController {
	@Autowired PtgService ptgService;
	@Autowired ClassesService classesService;
	//▶▶작가 찜
	//작가 찜 있는지 확인
	@RequestMapping("/silhyun/isZzim/{id}/{ctgrNum}")
	@ResponseBody
	public ResponseEntity<Boolean> isZzim(ZzimVO zvo,@PathVariable String id,@PathVariable String ctgrNum){
		zvo.setId(id);
		zvo.setCtgrNum(ctgrNum);
		boolean isZzim = ptgService.isZzim(zvo);
		return ResponseEntity.ok(isZzim);
	}
	
	//작가 찜 추가하기
	@PostMapping("/silhyun/insertZzim")
	public ResponseEntity<String> insertZzim(@RequestBody ZzimVO zvo){
		ptgService.insertZzim(zvo);
		return ResponseEntity.ok("ok");
	}
	
	//작가 찜 삭제
	@PostMapping("/silhyun/delZzim")
	public ResponseEntity<String> delZzim(@RequestBody ZzimVO zvo){
		ptgService.delZzim(zvo);
		return ResponseEntity.ok("ok");
	}
	
	//▶▶클래스 찜
	//클래스 찜 있는지 확인
	@RequestMapping("/silhyun/cIsZzim/{id}/{ctgrNum}")
	@ResponseBody
	public Boolean cIsZzim(ZzimVO zvo,@PathVariable String id,@PathVariable String ctgrNum){
		zvo.setId(id);
		zvo.setCtgrNum(ctgrNum);
		boolean isZzim = classesService.cIsZzim(zvo);
		return isZzim;
	}
	
	//클래스 찜 추가하기
	@PostMapping("/silhyun/cInsertZzim")
	public ResponseEntity<String> cInsertZzim(@RequestBody ZzimVO zvo){
		classesService.cInsertZzim(zvo);
		return ResponseEntity.ok("ok");
	}
	
	//클래스 찜 삭제
	@PostMapping("/silhyun/cDelZzim")
	public ResponseEntity<String> cDelZzim(@RequestBody ZzimVO zvo){
		classesService.cDelZzim(zvo);
		return ResponseEntity.ok("ok");
	}
	
	
}
