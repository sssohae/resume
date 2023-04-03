package co.yedam.silhyun.portfolio.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class PortfolioVO {

	
	private String portNum;
	private String ptgId;
	private String cntn;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date portDate;
	private String upSta;
	private int likes;//조아요수
	private String profile;
	
	
	
	//조인
	//Photo 사진불러오기
	private String phoNum;//사진경로
	private String ctgr;
	private String ctgrNum;
	private String phoRt;//경로

	
	//likePhoto//좋아요순용 
	private String id;
	
	//tag
	private String tagCntn;
	
	//comment 댓글순
//	private String ctgr_num;//카테고리넘버 //==포트포리오 번호
	private String comNum;//댓글번호
	private int dep;//댓글계층(원댓글 0/대댓글 1)
	private int grp;//댓글그룹//한묶음댓글
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date comDate;
	private String commentCntn;//댓글내용
}
