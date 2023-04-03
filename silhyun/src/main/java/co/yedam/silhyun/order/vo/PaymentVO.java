package co.yedam.silhyun.order.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
public class PaymentVO {
	String ordNum;
	String ctgr;
	String ctgrNum;
	String id;
	String resNum;
	String ordMthd;
	String uCpNum;
	int uPoint;
	String ordSta;
	Date ordDate;
	int paymPri;
	int ordPri;
	String revSta;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	Date shotDate;
	String name;
	String shotTime;
	String ttl;
	int discount;
	String shotPlace;
}
