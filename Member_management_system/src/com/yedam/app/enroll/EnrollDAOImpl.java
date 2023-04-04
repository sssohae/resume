package com.yedam.app.enroll;

import java.util.ArrayList;
import java.util.List;

import com.yedam.app.common.DAO;
import com.yedam.app.common.LoginControl;
import com.yedam.app.members.MembersVO;

public class EnrollDAOImpl extends DAO implements EnrollDAO {

	private static EnrollDAOImpl dao = null;

	private EnrollDAOImpl() {
	}

	public static EnrollDAOImpl getInstance() {
		if (dao == null) {
			dao = new EnrollDAOImpl();
		}
		return dao;
	}

	// 회원 수강현황
	@Override
	public List<EnrollVO> enrolledViewAll() {
		List<EnrollVO> list = new ArrayList<>();
		try {
			connect();
			stmt = conn.createStatement();
			String sql = "SELECT * FROM enrolled_class";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				EnrollVO enrlVO = new EnrollVO();
				enrlVO.setcNo(rs.getInt("class_no"));
				enrlVO.setcName(rs.getString("class_name"));
				enrlVO.setFromDate(rs.getString("from_date"));
				enrlVO.setToDate(rs.getString("to_date"));
				enrlVO.setEnrollDate(rs.getString("enroll_date"));
				enrlVO.setmNo(rs.getInt("member_no"));
				list.add(enrlVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;

	}

	// 수강중인 과목 조회
	@Override
	public List<EnrollVO> enrolledView() {
		List<EnrollVO> list = new ArrayList<>();
		try {
			connect();
			stmt = conn.createStatement();

			// 회원 본인 것만 보이도록 WHERE에 넣음. 이거는 매개변수를 안 받아서 어떻게 할 지 몰라 그냥 뒀습니다..
			MembersVO memVO = LoginControl.getLoginInfo();

			String sql = "SELECT * FROM enrolled_class WHERE member_no = " + memVO.getmNo();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				EnrollVO enrlVO = new EnrollVO();
				enrlVO.setcNo(rs.getInt("class_no"));
				enrlVO.setcName(rs.getString("class_name"));
				enrlVO.setFromDate(rs.getString("from_date"));
				enrlVO.setToDate(rs.getString("to_date"));
				enrlVO.setEnrollDate(rs.getString("enroll_date"));
				enrlVO.setmNo(rs.getInt("member_no"));
				list.add(enrlVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

}