package co.yedam.silhyun.qst.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class QstVO {
	private String qstNum;
	private String ctgr;
	private String ctgrNum;
	private String ttl;
	private String id;
	private String cntn;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date qstDate;
	private String rplySta;
	private String secretSta;
	
	
	// 조인용
	// comment 별칭 
	private String ansCntn;
	private String comNum;
	 
	
}
