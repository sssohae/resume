package co.yedam.silhyun.common.vo;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ReviewVO{
	private String revNum;
	private String ctgr;
	private String ctgrNum;
	private String id;
	private int star;
	private String cntn;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date revDate;
	private int hit;
	private String ordNum;
	private String phoY;
	private List<PhotoVO> photoList;
	
	private String phoRt;
	private String profile;
	
	//결제 정보 
	//옵션과 작가정보
	private String opNum;
	private String name;
	private String findOp;
    //클래스정보
	private String claTtl;
	private String ptgId;
	private String thni;
	private String classNum;
}
