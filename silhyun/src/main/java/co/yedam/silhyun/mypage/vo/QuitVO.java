package co.yedam.silhyun.mypage.vo;

import java.util.Date;

import lombok.Data;

@Data
public class QuitVO {

	String id;
	Date quitDate;
	String quitCd;
	String detaResn;
	private String pwd;
	
}
