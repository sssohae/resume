package co.yedam.silhyun.member.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MemberVO {
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
	private int coupon;
	private String loginCdNm;
	private String genCdNm;
	private String memCdNm;

}
