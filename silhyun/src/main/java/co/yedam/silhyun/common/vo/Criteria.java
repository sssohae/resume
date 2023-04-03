package co.yedam.silhyun.common.vo;

import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Data;

@Component
@Data
public class Criteria {
	private int pageNum; //현재 페이지 번호
	private int amount; //페이지당 출력할 개수
	private String keyword; //검색키워드
	private String type; //검색 유형(전체, 제목, 내용, 작성자 등..)
	private String sort; //리뷰 정렬  ===== 이 부분은 나중에 리뷰 보로 옮기기
	private String photo; // 포토리뷰 먼저보기
	
	//기본으로 보여주는것
	public Criteria() {
		this(1,10);
	}
	
	//매개값을 받아 값 조정
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	//UriComponenetBuilder사용해서 페이징 링크 생성(get방식일경우 사용?)
	public String getListLink() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
				.queryParam("pageNum", pageNum)
				.queryParam("amount", amount);
		return builder.toUriString();
	}
	
	//sql문에 타입값(T,C,W..) 배열로 전달 => 검색위해서
	public String[] getTypeArr() {
		return type == null ? new String[]{} : type.split("");
	}
}
