package co.yedam.silhyun.mypage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.yedam.silhyun.mypage.map.PointMapper;
import co.yedam.silhyun.mypage.vo.PointVO;
import co.yedam.silhyun.mypage.vo.UsedPointVO;

@Service
public class PointServiceImpl implements PointService {

	@Autowired PointMapper map;
	
	@Override
	public int pointInsert(PointVO vo) {
		return map.pointInsert(vo);
	}

	@Override
	public int usedPointInsert(UsedPointVO vo) {
		// TODO Auto-generated method stub
		return map.usedPointInsert(vo);
	}

}
