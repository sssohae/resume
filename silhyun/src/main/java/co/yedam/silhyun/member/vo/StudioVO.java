package co.yedam.silhyun.member.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class StudioVO {
	private String stId;
	private String regionCd;
	private String stName;
	private String addr;
	private String tel;
	private String ceoName;
	private String cfmCd;
	private String crn;
	private String latiAddr;
	private String lonAddr;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date accpDate;
	private String detAddr;
	private String zipAddr;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date regiDate;
	private String stProfile;
	private String stCd;
	private String stItr;
	
	private String searchWord;
	private String searchType;
	private String[] chkArray;
	
	private String profile; 
	private String name;
	private String workDay;
	private String id; 
}
