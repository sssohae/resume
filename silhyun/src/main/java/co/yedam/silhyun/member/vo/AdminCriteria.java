package co.yedam.silhyun.member.vo;

import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class AdminCriteria {
	
	private int pageNum; //현재 페이지 번호
	private int amount; //페이지당 출력할 개수
	private String keyword; //검색키워드
	private String type; //검색 유형
	private String birthDate;
	private String memCd;
	private String genCd;
	
	//기본으로 보여주는것
	public AdminCriteria() {
		this(1,10);
	}
	
	//매개값을 받아 값 조정
	public AdminCriteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
}
