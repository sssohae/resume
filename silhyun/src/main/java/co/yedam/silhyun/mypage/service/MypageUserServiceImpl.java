package co.yedam.silhyun.mypage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.yedam.silhyun.event.vo.CouponHistoryVO;
import co.yedam.silhyun.member.vo.MemberVO;
import co.yedam.silhyun.mypage.map.MypageUserMapper;
import co.yedam.silhyun.mypage.vo.ScheduleVO;

@Service
public class MypageUserServiceImpl implements MypageUserService{
	@Autowired MypageUserMapper mapper;
	
	@Override
	public List<ScheduleVO> getScheduleList(String id) {
		// TODO Auto-generated method stub
		return mapper.getScheduleList(id);
	}

	@Override
	public int scheduleInsert(ScheduleVO vo) {
		// TODO Auto-generated method stub
		return mapper.scheduleInsert(vo);
	}

	@Override
	public int scheduleDelete(ScheduleVO vo) {
		// TODO Auto-generated method stub
		return mapper.scheduleDelete(vo);
	}
	
	@Override
	public List<CouponHistoryVO> selectMyCoupon(String id) {
		
		return mapper.selectMyCoupon(id);
	}

	@Override
	public List<MemberVO> getMemberInfo(String id) {
		// TODO Auto-generated method stub
		return mapper.getMemberInfo(id);
	}


}
