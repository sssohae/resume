package co.yedam.silhyun.member.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import co.yedam.silhyun.common.vo.Criteria;
import lombok.Data;

@Data
public class PhotographerVO{
	private String ptgId;
	private String stId;
	private String regionCd;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date regiDate;
	private String crn;
	private String ptgCd;
	private String shotPlace;
	private String itr;
	private String inst;
	private String cfmCd;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date accpDate;
	private String workDay;
	private Double star;
	
	private String[] chkArray;  // 지역태그
	private String[] chkfldArray; //분야태그
	private String region;
	private String field;
	private String searchType;
	private String searchWord;
	
	//찜 개수 
	private String zzims;
	
	private String phoRt;
	private String stName;
	
	
	//조인
	private String id;
	private String name;
	private String pwd;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date birthDate;
	private String genCd;
	private String email;
	private String tel;
	private String rcomr;
	private String memCd;
	private String token;
	private String reToken;
	private String loginCd;
	private int pointSum;
	private String profile; 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date joinDate;
	
	private String ttl;
	private String cntn;
	private int pri;
	private String resTime;
	
	private String cdName;
	private String cd;
	private String opNum;
	private int RESYN;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date redate;
	private String rest;
	private String fldName;
	private String fdCd;

}
