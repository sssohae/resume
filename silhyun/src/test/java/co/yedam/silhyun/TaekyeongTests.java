package co.yedam.silhyun;

import java.io.File;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;

import co.yedam.silhyun.common.service.PageTestService;
import co.yedam.silhyun.common.service.PhotoService;
import co.yedam.silhyun.common.service.ReviewService;
import co.yedam.silhyun.common.vo.Criteria;
import co.yedam.silhyun.common.vo.PageVO;
import co.yedam.silhyun.common.vo.PhotoVO;
import co.yedam.silhyun.member.service.EmailService;

@SpringBootTest
public class TaekyeongTests {
	@Autowired PageTestService service;
	@Autowired EmailService emailService;
	@Autowired ReviewService rService;
	@Autowired PhotoService pService;

	//@Test
	public void 페이징검색테스트() {
		Criteria cri = new Criteria();
		
		  cri.setKeyword("리뷰"); cri.setType("C");
		 
		PageVO vo = new PageVO(100, 10, cri);
	}
	
	//@Test
	public void 총갯수() {
		Criteria cri = new Criteria();
		
		  cri.setKeyword("리뷰"); cri.setType("CW");
		 
		service.getTotalCount(cri);
		System.out.println("총갯수는?"  +service.getTotalCount(cri));
	}
	
	@Test //=> 가입인증번호
	public void mailConfirm() {
		String code = emailService.sendSimpleMessage("kkom_bom@naver.com", "join");
		System.out.println("인증코드>>>>>>>>>>>"+code);
	

	}
	
	//@Test  => 비번 암호화 하는거
	public void test() {
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(10);
		String result = bcrypt.encode("1111");
		Boolean matchYn = bcrypt.matches("1111", result);
		System.out.println(result);
		System.out.println(matchYn);
		
	}
	
	//파일삭제
	//@Test
	public void delete() {
		PhotoVO vo = new PhotoVO();
		List<PhotoVO> list = pService.photoList(vo);
		for(PhotoVO pvo : list) {
			//파일삭제
			File file = new File("c:" + pvo.getPhoRt());
			File thum = new File("c:" + pvo.getThumbnail());
			if(file.exists()) {
				file.delete();
				thum.delete();
			}
			
		}
		//db파일 삭제
		pService.photoAllDelete();

	}
	
}
