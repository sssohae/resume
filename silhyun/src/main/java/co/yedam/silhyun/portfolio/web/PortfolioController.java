package co.yedam.silhyun.portfolio.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import co.yedam.silhyun.common.service.PhotoService;
import co.yedam.silhyun.common.vo.PhotoVO;
import co.yedam.silhyun.member.vo.PhotographerVO;
import co.yedam.silhyun.portfolio.service.PortfolioService;
import co.yedam.silhyun.portfolio.vo.PortfolioVO;

@Controller
public class PortfolioController {

	@Autowired
	private PortfolioService portfolioService;
	@Autowired
	private PhotoService photoService;

	@GetMapping("/silhyun/portfolio/{ptgId}")
	public String portfolio(Model model, PortfolioVO portfolioVO) {
		return "portfolio/portfolio";
	}

	@RequestMapping("/silhyun/portfolioInsert")
	public String portfolioInsertForm(Model model, PortfolioVO portfolioVO) {
		return "portfolio/portfolioInsertForm";
	}

	@RequestMapping("/silhyun/modalTest") // 모달화면구현~
	public String modalTest(Model model) {
		return "portfolio/modalTest";
	}

	@RequestMapping("/silhyun/detailPortfolioPhoto/{portNum}") // 포트폴리오 번호당 디테일포토 가져오기.
	@ResponseBody
	public List<PortfolioVO> detailPortPhoto(Model model, PortfolioVO vo, @PathVariable String portNum) {
		model.addAttribute("detailPortfolioPhoto", portfolioService.detailPortfolioPhoto(portNum));
		return portfolioService.detailPortfolioPhoto(portNum);
	}

	@RequestMapping("/silhyun/portfolioptg/{ptgId}") // 포트폴리오상세페이지 해당작가정보
	@ResponseBody
	public List<PhotographerVO> portPtg(Model model, PhotographerVO vo, @PathVariable String ptgId) {
		model.addAttribute("portfolioPtg", portfolioService.portfolioPtg(ptgId));
		return portfolioService.portfolioPtg(ptgId);
	}

	@RequestMapping("/silhyun/ptgField/{ptgId}") // 해당작가필드리스트
	@ResponseBody
	public List<PhotographerVO> portPtgField(Model model, PhotographerVO vo, @PathVariable String ptgId) {
		model.addAttribute("ptgField", portfolioService.ptgField(ptgId));
		return portfolioService.ptgField(ptgId);
	}

	@RequestMapping("/silhyun/ptgPortfolioList/{ptgId}") // 작가별 포트폴리오리스트 띄우기
	@ResponseBody
	public List<PortfolioVO> ptgPortList(Model model, PortfolioVO vo, @PathVariable String ptgId) {
		model.addAttribute("ptgPortList", portfolioService.ptgPortfolioList(ptgId));
		return portfolioService.ptgPortfolioList(ptgId);
	}

	// insert
	@PostMapping("/silhyun/addPortfolio")
	public ResponseEntity<?> insertPortfolio(@RequestParam("files") List<MultipartFile> files,
			PortfolioVO portfolioVO) {
		try {
			String ctgrNum = portfolioService.insertPortfolio(files, portfolioVO);
			photoService.photoInsert(files, ctgrNum, "P");
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@RequestMapping("/silhyun/imsiList/{ptgId}") // 작가별 포트폴리오리스트 띄우기
	@ResponseBody
	public List<PortfolioVO> ptgImsiList(Model model, PortfolioVO vo, @PathVariable String ptgId) {
		model.addAttribute("imsiList", portfolioService.imsiList(ptgId));
		return portfolioService.imsiList(ptgId);
	}

	@RequestMapping("/silhyun/portfolioUpdate")
	public String portfolioUpdateForm(Model model, PortfolioVO vo) {
		return "portfolio/portfolioUpdateForm";
	}

	@GetMapping("/silhyun/portfolioSelectOne") // 업데이트 위한 selectOne
	@ResponseBody
	public Map<String, Object> portfolioSelectOne(@RequestParam String portNum, Model model, PortfolioVO portfolioVO,
			PhotoVO photoVO) {
		portfolioVO = portfolioService.portfolioSelectOne(portNum);
		List<PhotoVO> photos = photoService.photoList(photoVO);
		Map<String, Object> result = new HashMap<>();
		result.put("portfolio", portfolioVO);
		result.put("photos", photos);
		return result;
	}

	@PostMapping("/silhyun/updatePortfolio")
	public ResponseEntity<?> updatePortfolio(@RequestParam(value = "files", required = false) List<MultipartFile> files,
			@RequestParam("deletePhotos") List<String> deletePhotos, PortfolioVO portfolioVO) {
		try {
			if (files != null) {
				String ctgrNum = portfolioService.updatePortfolio(portfolioVO);
				photoService.photoInsert(files, ctgrNum, "P");
			} else {
				portfolioService.updatePortfolio(portfolioVO);
			}

			if (!deletePhotos.isEmpty()) {
				for (String photoNum : deletePhotos) {
					PhotoVO photoVO = new PhotoVO();
					photoVO.setPhoNum(photoNum);
					photoService.photoDelete(photoVO);
				}
			}
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DeleteMapping("/silhyun/portfolioDelete/{portNum}")
	public ResponseEntity<?> deletePortfolio(@PathVariable String portNum) {
		PhotoVO pvo = new PhotoVO();
		pvo.setCtgr("R");
		pvo.setCtgrNum(portNum);
		portfolioService.deletePortfolio(portNum);
		return ResponseEntity.ok().build();
	}

}
