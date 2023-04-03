package co.yedam.silhyun.mypage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.yedam.silhyun.classes.vo.ClassesVO;
import co.yedam.silhyun.common.vo.Criteria;
import co.yedam.silhyun.event.vo.CouponVO;
import co.yedam.silhyun.event.vo.EventVO;
import co.yedam.silhyun.member.vo.MemberVO;
import co.yedam.silhyun.member.vo.OptionsVO;
import co.yedam.silhyun.member.vo.PhotographerVO;
import co.yedam.silhyun.member.vo.ReserTimeVO;
import co.yedam.silhyun.mypage.map.MypageAoMapper;
import co.yedam.silhyun.order.vo.ReserVO;

@Service
public class MypageAoServiceImpl implements MypageAoService {
	
	@Autowired
	private MypageAoMapper mypageAoMapper;
	
	@Override
	public int getReserList(String ptgId){
		
		return mypageAoMapper.getReserList(ptgId);
	}
	
	@Override
	public List<MemberVO> getPhotoinfo(String id){
		
		return mypageAoMapper.getPhotoinfo(id);
	}

	@Override
	public int ptgInfoUpdate(MemberVO vo) {
	
		return mypageAoMapper.ptgInfoUpdate(vo);
	}
	@Override
	public int applyEvent(EventVO vo) {
		
		return mypageAoMapper.applyEvent(vo);
	}
	
	@Override
	public int applyECoupon(CouponVO vo) {
		
		return mypageAoMapper.applyECoupon(vo);
	}

	@Override
	public int applyClass(ClassesVO vo) {

		return mypageAoMapper.applyClass(vo);
	}

	@Override
	public int insertOption(OptionsVO vo) {
		// TODO Auto-generated method stub
		return mypageAoMapper.insertOption(vo);
	}

	
	  @Override public int updateReserTime(ReserTimeVO vo) {
	  
	  return mypageAoMapper.updateReserTime(vo);
	  }
	 


	@Override
	public int updateReserTime(List<ReserTimeVO> voList) {
		return mypageAoMapper.updateReserTime(voList);
	}


	@Override
	public int insertReserTime(ReserTimeVO vo) {
		
		return mypageAoMapper.insertReserTime(vo);
	}

	@Override
	public int deleteReserTime(String id) {
		// TODO Auto-generated method stub
		return mypageAoMapper.deleteReserTime(id);
	}

	

	@Override
	public MemberVO ptgSelect(MemberVO vo) {

		return mypageAoMapper.ptgSelect(vo);
	}

	@Override
	public List<ClassesVO> classList(String ptgId, Criteria cri) {

		return mypageAoMapper.classList(ptgId,cri);

	}

	@Override
	public List<PhotographerVO> getPtg(String ptgId) {

		return mypageAoMapper.getPtg(ptgId);
	}

	@Override
	public List<PhotographerVO> getResTime(String ptgId, String redate) {

		return mypageAoMapper.getResTime(ptgId, redate);
	}

	@Override
	public int updateWorkday(PhotographerVO vo) {

		return mypageAoMapper.updateWorkday(vo);
	}

	@Override
	public PhotographerVO selectWorkDay(String ptgId) {

		return mypageAoMapper.selectWorkDay(ptgId);
	}

	@Override
	public List<MemberVO> getInquiryC() {
//수강자조회
		return mypageAoMapper.getInquiryC();
	}

	@Override
	public List<PhotographerVO> getResInfo(String ptgId, String redate, String shotTime) {

		return mypageAoMapper.getResInfo(ptgId, redate, shotTime);
	}

	@Override
	public List<MemberVO> clMemInfo(String classNum) {

		return mypageAoMapper.clMemInfo(classNum);
	}

	@Override
	public int uploadPhoto(ReserVO vo) {

		return mypageAoMapper.uploadPhoto(vo);
	}

	@Override
	public List<ReserVO> selectReserList(String ptgId, Criteria cri) {
		
		return mypageAoMapper.selectReserList(ptgId, cri);
	}

	@Override
	public int totalClassList(String ptgId) {
		return mypageAoMapper.totalClassList(ptgId);
	}

	@Override
	public List<ReserTimeVO> ptgRestime(String ptgId) {

		return mypageAoMapper.ptgRestime(ptgId);
	}


	



}
