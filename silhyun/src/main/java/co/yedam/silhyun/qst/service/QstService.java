package co.yedam.silhyun.qst.service;

import java.util.List;

import co.yedam.silhyun.common.vo.CommentVO;
import co.yedam.silhyun.qst.vo.QstVO;

public interface QstService {

	List<QstVO> getAoQstList(); // 작가 문의글 리스트
	
	int aoQstInsert(QstVO vo); // 작가 문의글 입력
	int aoQstDelete(QstVO vo); // 작가 문의글 삭제
	int aoQstUpdate(QstVO vo); // 작가 문의글 수정
	
	int aoAnsInsert(CommentVO cvo); // 작가 문의 답변 입력
	int aoAnsDelete(CommentVO cvo); // 작가 문의 답변 삭제
	int aoAnsUpdate(CommentVO cvo); // 작가 문의 답변 수정
	
	List<QstVO> getClassQstList(); // 작가 문의글 리스트
	
	int classQstInsert(QstVO vo); // 작가 문의글 입력
	int classQstDelete(QstVO vo); // 작가 문의글 삭제
	int classQstUpdate(QstVO vo); // 작가 문의글 수정
	
	int classAnsInsert(CommentVO cvo); // 작가 문의 답변 입력
	int classAnsDelete(CommentVO cvo); // 작가 문의 답변 삭제
	int classAnsUpdate(CommentVO cvo); // 작가 문의 답변 수정
	
}
