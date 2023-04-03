package co.yedam.silhyun.member.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class AdminPageVO {
	
	private int pageCount; //페이지 사이즈(1~10)
	private int startPage; //시작페이지(1)
	private int endPage; //끝페이지(10)
	private int realEnd; //실제마지막 번호
	private boolean prev, next; //이전, 다음 페이지 존재여부
	private int total; //전체 데이터 갯수
	private AdminCriteria criteria; //criteria 클래스 변수값 부르기 위해

	public AdminPageVO() {
		// 기본 생성자
	}

	public AdminPageVO(int total, int pageCount, AdminCriteria criteria) {
		this.total = total;
		this.criteria = criteria;
		this.pageCount = pageCount;

		this.endPage = (int)(Math.ceil(criteria.getPageNum()*1.0/pageCount))*pageCount;
		this.startPage = endPage - (pageCount-1);

		realEnd = (int)(Math.ceil(total*1.0/criteria.getAmount()));

		//만약 진짜 끝페이지가 끝페이지보다 작다면
		if(endPage > realEnd) {
			//끝페이지, 진짜끝페이지가 0이면 1, 아니면 진짜끝페이지번호
			endPage = realEnd == 0 ? 1 : realEnd;
		}

		prev = startPage > 1;
		next = endPage < realEnd;
	}
	
}
