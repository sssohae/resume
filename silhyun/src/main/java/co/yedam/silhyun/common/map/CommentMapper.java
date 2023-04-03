package co.yedam.silhyun.common.map;

import java.util.List;

import co.yedam.silhyun.common.vo.CommentVO;


public interface CommentMapper {
	List<CommentVO> getCommentList(String portNum); // 댓글 리스트
	
	int commentInsert(CommentVO vo); // 댓글 입력
	
	int commentDelete(CommentVO vo); // 댓글 삭제
	

	

	
	int replyDelete(CommentVO vo); // 대댓글 삭제
	
	
	
}
