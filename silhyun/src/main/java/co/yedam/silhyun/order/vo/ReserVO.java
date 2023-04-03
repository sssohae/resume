package co.yedam.silhyun.order.vo;

import java.util.Date;


import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
public class ReserVO {
	String resNum;
	String ptgId;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	Date shotDate;
	String id;
	String shotTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	Date regiDate;
	String resCd;
	String resSta;
	int resPri;
	String mainP;
	
	//조인
	int poNum;
	int savePo;
	Date saveDate;
	int saveNum;
	private int pointSum;
	private String cpnNum;
	private String ctgr;
	private String ctgrNum;
	private String cntn;
	private int discount;
	private String cpnCd;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date startDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date endDate;
	private String eventNum;
	private String cpnSta;
	private String claTtl;
}
