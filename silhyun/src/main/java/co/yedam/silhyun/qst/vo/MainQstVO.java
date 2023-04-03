package co.yedam.silhyun.qst.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MainQstVO {

	private String mainNum;
	private int grp;
	private int ord;
	private int dep;
	private String id;
	private String assortCd;
	private String ttl;
	private String cntn;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date mainDate;
	private int hit;
	private String secretSta;
	private String rplySta;
}
