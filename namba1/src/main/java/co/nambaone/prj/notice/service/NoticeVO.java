package co.nambaone.prj.notice.service;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeVO {
	private int noticeId;
	@JsonFormat(pattern="yyyy-MM-dd", timezone="Asia/Seoul")
	private Date noticeDate;
	private String noticeTitle;
	private String noticeSubject;
	private int noticeHit;
	
	private int attechId;   //join을 위한 확장
	private String noticeFile; //join을 위한 확장
	private String noticeFileDir; //join을 위한 확장	
}
