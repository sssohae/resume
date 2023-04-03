package co.yedam.silhyun.common.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class CommentVO {
	private String comNum;
	private String ctgr;
	private String ctgrNum;
	private int dep;
	private int ord;
	private int grp;
	private String id;
	private String cntn;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date comDate;
	private int repCnt;
	private String profile;
	
	
	// 답변삭제시 사용용
	private int qstNum;
}	
