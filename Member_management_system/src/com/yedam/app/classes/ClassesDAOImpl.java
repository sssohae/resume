package com.yedam.app.classes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.yedam.app.common.DAO;
import com.yedam.app.members.MembersVO;

public class ClassesDAOImpl extends DAO implements ClassesDAO {

	// 싱글톤. 필드에도 private해서 외부에서 값 변경 못하게
	private static ClassesDAOImpl dao = null;

	// 외부에서 생성 못 하게 private
	private ClassesDAOImpl() {
	}

	// 외부에서 호출 할 수 있는 정적 메소드. 정적필드에서 참조하고 있는 자신의 객체를 리턴해준다.
	public static ClassesDAOImpl getInstance() {
		if (dao == null) {
			dao = new ClassesDAOImpl();
		}
		return dao;
	}

	// 수강과목 전체조회
	@Override
	public List<ClassesVO> viewAllC() {
		List<ClassesVO> list = new ArrayList<>();
		try {
			connect();
			stmt = conn.createStatement();
			String sql = "SELECT * FROM class_list";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				ClassesVO clsVO = new ClassesVO();
				clsVO.setcNo(rs.getInt("class_no"));
				clsVO.setcName(rs.getString("class_name"));
				clsVO.setcIntro(rs.getString("class_intro"));
				clsVO.setFromDate(rs.getString("from_date"));
				clsVO.setToDate(rs.getString("to_date"));
				list.add(clsVO);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 수강신청
	@Override
	public void enrollC(ClassesVO csVO, MembersVO mVO) {
		try {
			connect();
			String sql = "INSERT INTO enrolled_class VALUES(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			// 시스템에서 현재 날짜 받기
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String strNow = sdf.format(now);

			pstmt.setInt(1, csVO.getcNo());
			pstmt.setString(2, csVO.getcName());
			pstmt.setString(3, csVO.getFromDate());
			pstmt.setString(4, csVO.getToDate());
			pstmt.setString(5, strNow);
			pstmt.setInt(6, mVO.getmNo());

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("수강신청이 완료되었습니다.");
			} else {
				System.out.println("*정상적으로 신청되지 않았습니다.*");
			}
		} catch (Exception e) {
			System.out.println("*이미 수강 중인 과목입니다.*");
		} finally {
			disconnect();
		}

	}

	// 수강과목 확인
	@Override
	public ClassesVO confirmC(ClassesVO csVO) {
		ClassesVO cnfClsVO = null;
		try {
			connect();
			stmt = conn.createStatement();

			String sql = "SELECT * FROM class_list WHERE class_no = " + csVO.getcNo();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				cnfClsVO = new ClassesVO();
				cnfClsVO.setcNo(rs.getInt("class_no"));
				cnfClsVO.setcName(rs.getString("class_name"));
				cnfClsVO.setcIntro(rs.getString("class_intro"));
				cnfClsVO.setFromDate(rs.getString("from_date"));
				cnfClsVO.setToDate(rs.getString("to_date"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return cnfClsVO;

	}
}
