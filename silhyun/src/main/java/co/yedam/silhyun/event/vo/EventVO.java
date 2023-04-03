package co.yedam.silhyun.event.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class EventVO {
	private String eventNum;
	private String id;
	private String name;
	private int term;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date startDate;
	private String cntn;
	private String thni;
	private String bnph;
	private String bnphSta;
	private String cfmCd;
	private String cpnPubSta;
	private String regionCd;
	private Date accpDt;

}
