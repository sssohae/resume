package co.yedam.silhyun.mypage.web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import co.yedam.silhyun.SessionUser;
import co.yedam.silhyun.member.service.StdService;
import co.yedam.silhyun.member.vo.MemberVO;
import co.yedam.silhyun.member.vo.PhotographerVO;
import co.yedam.silhyun.member.vo.StudioVO;
import co.yedam.silhyun.mypage.service.MypageAoService;

@Controller
public class MyStdController {

	@Value("${silhyun.saveimg}")
	private String saveimg;
	
	@Autowired
	private StdService stdService;
	private MypageAoService mypagesAoService;

	
	@RequestMapping("/photo/mypageStd")
	private String mypageStd(Model model, StudioVO svo, HttpSession session) {
		String id = (String)session.getAttribute("id");
		model.addAttribute("stdInfo", stdService.stdlistget(id));
		return "mypageStd/mypageStd";
	}
	
	@RequestMapping("/photo/modStd")
	public String modStd(Model model,HttpSession session) {
		String id = (String)session.getAttribute("id");
		model.addAttribute("stdInfo", stdService.stdlistget(id));

		return "mypageStd/modStd";
	}
	
	@RequestMapping("/photo/stdManage")
	private String stdManage(Model model,HttpSession session)
	{	
		String id = (String)session.getAttribute("id");
		model.addAttribute("stdInfo", stdService.stdlistget(id));
		model.addAttribute("ptglist", stdService.ptgList(id));
		return "mypageStd/stdManage";
	}
	
	//삭제


	@PostMapping("/ptgdel")
	@ResponseBody
	public boolean ptgdel(String ptgId) {
		System.out.println(ptgId+"들어오나ㅏㅏㅏㅏㅏㅏㅏㅏ");//null값
		stdService.ptgdel(ptgId);
		return true;
	}
	
	//프사변경
		@PostMapping("/uploadstProfileImage")
		@ResponseBody
		public Map<String,Object> uploadstProfileImage(StudioVO vo, MultipartFile file){
			System.out.println("프사볼려는 멤버보?" + vo);
			System.out.println("프사 들어오는지 확인" + file);
			Map<String, Object> map = new HashMap<>();
			
			if (file != null && !file.isEmpty()) {
				String saveImgPath = saveimg + "profil";

				String fileName = UUID.randomUUID().toString(); // UUID생성
				fileName = fileName + "_" + file.getOriginalFilename(); // 유니크한 아이디
				File uploadFile = new File(saveImgPath, fileName);
				
				try {
					file.transferTo(uploadFile); // 파일저장
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				vo.setStProfile("/saveImg/profil/" + fileName);
				stdService.updatestProfileImage(vo);
				map.put("vo", vo);
				map.put("profile", file);
			
			}
			
			return map;
		}

	

}
