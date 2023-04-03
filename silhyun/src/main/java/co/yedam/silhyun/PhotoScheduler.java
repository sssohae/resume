package co.yedam.silhyun;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import co.yedam.silhyun.common.service.PhotoService;
import co.yedam.silhyun.common.vo.PhotoVO;

@Component
public class PhotoScheduler {
	
	@Autowired PhotoService pService;
	
	//매일 밤 00시에 파일 삭제 
	@Scheduled(cron = "0 0 0 * * *")
	public void photoDelete() {
		PhotoVO vo = new PhotoVO();
		List<PhotoVO> list = pService.photoList(vo);
		for(PhotoVO pvo : list) {
			//파일삭제
			File file = new File("/home/ubuntu" + pvo.getPhoRt());
			File thum = new File("/home/ubuntu" + pvo.getThumbnail());
			if(file.exists()) {
				file.delete();
				thum.delete();
			}
			
		}
		//db파일 삭제
		pService.photoAllDelete();

	}

}
