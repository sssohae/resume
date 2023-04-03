package co.yedam.silhyun.classes.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ClassesVO {

	private String classNum;
	private String ptgId;
	private String claTtl;
	private String claCd;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date claDt;	
	private String claTime;
	private String claPlace;
	private int ydt;
	private int ypsn;
	private int pcnt;
	private String claDesct;
	private int claCnt;
	private String thni;
	private int claPri;
	private String cfmSta;
	private String ot;
	private int rati;	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date accpDt;
	
}
