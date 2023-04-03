package co.yedam.silhyun.portfolio.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.yedam.silhyun.portfolio.service.PortfolioService;
import co.yedam.silhyun.portfolio.vo.LikePhotoVO;

@Controller
public class LikeController {

	@Autowired
	private PortfolioService portfolioService;

	@RequestMapping("/silhyun/isLiked/{id}/{portNum}")
	@ResponseBody
	public ResponseEntity<Boolean> isLiked(@PathVariable String id, @PathVariable String portNum) {
		LikePhotoVO like = new LikePhotoVO();
		like.setId(id);
		like.setPortNum(portNum);
		boolean isLiked = portfolioService.isLiked(like);
		return ResponseEntity.ok(isLiked);
	}

	@PostMapping("/silhyun/addLike") // 조아요 추가하기
	public ResponseEntity<String> addLike(@RequestBody LikePhotoVO like) {
		portfolioService.addLike(like);
		return ResponseEntity.ok("success");
	}

	@PostMapping("/silhyun/deleteLike") // 조아요 삭제
	public ResponseEntity<String> removeLike(@RequestBody LikePhotoVO like) {
		portfolioService.removeLike(like);
		return ResponseEntity.ok("success");
	}

}
