package co.nambaone.prj.user.service;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVO {
	private String userEmail;
	private String userPassword;
	private String userTel;
	private int report;
	private String cardNumber;
	private Date payDate;
	private Date joinDate;
	private String userAuthor;
	private String userNickname;
}
