package co.nambaone.prj.notice.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeAttechVO {
	private int attechId;
	private int noticeId;
	private String noticeFile;
	private String noticeFileDir;	
}
