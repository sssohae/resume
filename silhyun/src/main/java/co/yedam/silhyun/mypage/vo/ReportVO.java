package co.yedam.silhyun.mypage.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ReportVO {

	String repoNum;
	String ctgr;
	String ctgrNum;
	String id;
	String typCd;
	String result;
	String tretCd;
	int tretTerm;
	Date tretDate;
	boolean sancSta;
	
}
