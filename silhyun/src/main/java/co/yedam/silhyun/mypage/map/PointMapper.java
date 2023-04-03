package co.yedam.silhyun.mypage.map;

import co.yedam.silhyun.mypage.vo.PointVO;
import co.yedam.silhyun.mypage.vo.UsedPointVO;

public interface PointMapper {
	int pointInsert(PointVO vo);
	int usedPointInsert(UsedPointVO vo);
}
