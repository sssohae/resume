package co.yedam.silhyun.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.yedam.silhyun.order.map.SelectedOpMapper;
import co.yedam.silhyun.order.vo.SelectedOpVO;

@Service
public class SelectedOpServiceImpl implements SelectedOpService{
	@Autowired SelectedOpMapper selectedOpMapper;
	
	@Override
	public int selectedOpInsert(SelectedOpVO vo) {
		return selectedOpMapper.selectedOpInsert(vo);
	}

}
