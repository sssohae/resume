package co.yedam.silhyun.mypage.service;

import co.yedam.silhyun.mypage.vo.PointVO;
import co.yedam.silhyun.mypage.vo.UsedPointVO;

public interface PointService {
	int pointInsert(PointVO vo);
	int usedPointInsert(UsedPointVO vo);   //사용포인트vo를 사용
}
