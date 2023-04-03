package co.yedam.silhyun.qst.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.yedam.silhyun.common.map.CommentMapper;
import co.yedam.silhyun.common.vo.CommentVO;
import co.yedam.silhyun.qst.map.QstMapper;
import co.yedam.silhyun.qst.vo.QstVO;

@Service
public class QstServiceImpl implements QstService {

	@Autowired QstMapper mapper;
	
	@Override
	public List<QstVO> getAoQstList() {
		// TODO Auto-generated method stub
		return mapper.getAoQstList();
	}

	@Override
	public int aoQstInsert(QstVO vo) {
		// TODO Auto-generated method stub
		return mapper.aoQstInsert(vo);
	}

	@Override
	public int aoQstDelete(QstVO vo) {
		// TODO Auto-generated method stub
		return mapper.aoQstDelete(vo);
	}

	@Override
	public int aoQstUpdate(QstVO vo) {
		// TODO Auto-generated method stub
		return mapper.aoQstUpdate(vo);
	}
	
	@Override
	public int aoAnsInsert(CommentVO cvo) {
		// TODO Auto-generated method stub
		return mapper.aoAnsInsert(cvo);
	}

	@Override
	public int aoAnsDelete(CommentVO cvo) {
		// TODO Auto-generated method stub
		return mapper.aoAnsDelete(cvo);
	}


	@Override
	public int aoAnsUpdate(CommentVO cvo) {
		// TODO Auto-generated method stub
		return mapper.aoAnsUpdate(cvo);
	}

	@Override
	public List<QstVO> getClassQstList() {
		// TODO Auto-generated method stub
		return mapper.getClassQstList();
	}

	@Override
	public int classQstInsert(QstVO vo) {
		// TODO Auto-generated method stub
		return mapper.classQstInsert(vo);
	}

	@Override
	public int classQstDelete(QstVO vo) {
		// TODO Auto-generated method stub
		return mapper.classQstDelete(vo);
	}

	@Override
	public int classQstUpdate(QstVO vo) {
		// TODO Auto-generated method stub
		return mapper.classQstUpdate(vo);
	}

	@Override
	public int classAnsInsert(CommentVO cvo) {
		// TODO Auto-generated method stub
		return mapper.classAnsInsert(cvo);
	}

	@Override
	public int classAnsDelete(CommentVO cvo) {
		// TODO Auto-generated method stub
		return mapper.classAnsDelete(cvo);
	}

	@Override
	public int classAnsUpdate(CommentVO cvo) {
		// TODO Auto-generated method stub
		return mapper.classAnsUpdate(cvo);
	}

	

}
