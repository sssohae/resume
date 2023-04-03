package co.yedam.silhyun.member.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.yedam.silhyun.event.vo.EventVO;
import co.yedam.silhyun.member.map.AdminMapper;
import co.yedam.silhyun.member.vo.AdminCriteria;
import co.yedam.silhyun.member.vo.MemberVO;
import co.yedam.silhyun.member.vo.PhotographerVO;
import co.yedam.silhyun.member.vo.StudioVO;
import co.yedam.silhyun.mypage.vo.QuitVO;


@Service
public class AdminServiceImpl implements AdminSercive {

	@Autowired
	private AdminMapper adminMapper;
	
	
	
	//대시보드 =========================================
	@Override
	public Map<String, Object> cfmCnt() {
		return adminMapper.cfmCnt();
	}

	@Override
	public List<Map<String, Object>> lastSales() {
		return adminMapper.lastSales();
	}
	
	@Override
	public List<Map<String, Object>> recentCom() {
		return adminMapper.recentCom();
	}

	@Override
	public List<MemberVO> recentJoin() {
		return adminMapper.recentJoin();
	}

	@Override
	public List<Map<String, Object>> recentBuy() {
		return adminMapper.recentBuy();
	}

	@Override
	public List<Map<String, String>> ptgGraph() {
		return adminMapper.ptgGraph();
	}
	
	@Override
	public List<Map<String, Object>> ptgRank() {
			return adminMapper.ptgRank();
	}

	@Override
	public List<Map<String, Object>> classRank() {
		return adminMapper.classRank();
	}
	
	
	
	//전체 회원관리 =========================================
	@Override
	public List<MemberVO> memberList(){
		return adminMapper.memberList();
	}
	
	@Override
	public int updateMember(MemberVO vo) {
		return adminMapper.updateMember(vo);
	}

	@Override
	public List<Map<String, Object>> ptgList() {
		return adminMapper.ptgList();
	}

	@Override
	public List<StudioVO> stdList() {
		return adminMapper.stdList();
	}
	
	@Override
	public List<PhotographerVO> belongPtg(String stId) {
		return adminMapper.belongPtg(stId);
	}

	@Override
	public List<MemberVO> todayMem() {
		return adminMapper.todayMem();
	}

	@Override
	public List<MemberVO> todayPtg() {
		return adminMapper.todayPtg();
	}

	@Override
	public List<MemberVO> todayStd() {
		return adminMapper.todayStd();
	}
	
	@Override
	public int disableMember(String id) {
		return adminMapper.disableMember(id);
	}

	@Override
	public int ableMember(String id) {
		return adminMapper.ableMember(id);
	}
	


	//종합승인관리 =========================================
	@Override
	public List<Map<String, Object>> ptgCfmList() {
		return adminMapper.ptgCfmList();
	}

	@Override
	public Map<String, Object> ptgSelect(String ptgId) {
		return adminMapper.ptgSelect(ptgId);
	}

	@Override
	public int ptgAccept(String ptgId) {
		return adminMapper.ptgAccept(ptgId);
	}

	@Override
	public int noPtgAccept(String ptgId) {
		return adminMapper.noPtgAccept(ptgId);
	}
	
	@Override
	public List<Map<String, Object>> stdCfmList() {
		return adminMapper.stdCfmList();
	}

	@Override
	public Map<String, Object> stdSelect(String stId) {
		return adminMapper.stdSelect(stId);
	}

	@Override
	public int stdAccept(String stId) {
		return adminMapper.stdAccept(stId);
	}

	@Override
	public int noStdAccept(String stId) {
		return adminMapper.noStdAccept(stId);
	}
	
	@Override
	public List<Map<String, Object>> classCfmList() {
		return adminMapper.classCfmList();
	}

	@Override
	public Map<String, Object> classSelect(String classNum) {
		return adminMapper.classSelect(classNum);
	}

	@Override
	public int classAccept(String classNum) {
		return adminMapper.classAccept(classNum);
	}

	@Override
	public int noClassAccept(String classNum) {
		return adminMapper.noClassAccept(classNum);
	}

	@Override
	public List<Map<String, Object>> getEventOList() {
		return adminMapper.getEventOList();
	}

	@Override
	public int eventAccept(String eventNum) {
		return adminMapper.eventAccept(eventNum);
	}

	@Override
	public int noEventAccept(String eventNum) {
		return adminMapper.noEventAccept(eventNum);
	}

	@Override
	public Map<String, Object> countNeedCfm() {
		return adminMapper.countNeedCfm();
	}
	
	

	//이벤트관리
	@Override
	public List<Map<String, Object>> getEventList() {
		return adminMapper.getEventList();
	}

	@Override
	public EventVO getEventContent(String eventNum) {
		return adminMapper.getEventContent(eventNum);
	}

	@Override
	public List<Map<String, Object>> getEventAllList() {
		return adminMapper.getEventAllList();
	}

	@Override
	public Map<String, String> getEventCnt() {
		return adminMapper.getEventCnt();
	}

	
	
	//관리자계정관리 =========================================
	@Override
	public MemberVO adminInfo() {
		return adminMapper.adminInfo();
	}
	
	@Override
	public int updateAdmin(MemberVO vo) {
		return adminMapper.updateAdmin(vo);
	}
	
	
	
	//탈퇴관리 =========================================
	public List<QuitVO> qtList() {
		return adminMapper.qtList();
	}

	@Override
	public List<Map<String, Object>> getListQuit(AdminCriteria cri) {
		return adminMapper.getListQuit(cri);
		}

	@Override
	public int getTotalQuit(AdminCriteria cri) {
		return adminMapper.getTotalQuit(cri);
	}
	
	@Override
	public List<Map<String, String>> quitGraph() {
		return adminMapper.quitGraph();
	}


	
	//페이징
	@Override
	public List<MemberVO> getListMember(AdminCriteria cri) {
		return adminMapper.getListMember(cri);
	}

	@Override
	public int getTotalCount(AdminCriteria cri) {
		return adminMapper.getTotalCount(cri);
	}

	@Override
	public List<Map<String, Object>> getListPtg(AdminCriteria cri2) {
			return adminMapper.getListPtg(cri2);
	}

	@Override
	public int getTotalPtg(AdminCriteria cri2) {
			return adminMapper.getTotalPtg(cri2);
	}
	
	
	//사진관리스트 페이징
	@Override
	public List<Map<String, Object>> getListStd(AdminCriteria cri3) {
		return adminMapper.getListStd(cri3);
	}

	@Override
	public int getTotalStd(AdminCriteria cri3) {
		return adminMapper.getTotalStd(cri3);
	}



}
