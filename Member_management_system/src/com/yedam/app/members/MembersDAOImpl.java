package com.yedam.app.members;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.app.common.DAO;

public class MembersDAOImpl extends DAO implements MembersDAO {

	// 싱글톤. 필드에 private해서 외부에서 값 변경 못하게
	private static MembersDAOImpl dao = null;

	// 외부에서 생성 못 하게 private
	private MembersDAOImpl() {
	}

	// 외부에서 호출 할 수 있는 정적 메소드. 정적필드에서 참조하고 있는 자신의 객체를 리턴해준다.
	public static MembersDAOImpl getInstance() {
		if (dao == null) {
			dao = new MembersDAOImpl();
		}
		return dao;
	}

	@Override
	public List<MembersVO> viewAllM() {
		// ArrayList는 List의 구현 클래스. 왼쪽 List에 지정된 타입을 따라간다.
		List<MembersVO> list = new ArrayList<>();
		try {
			connect();
			stmt = conn.createStatement();
			String sql = "SELECT * FROM member_management";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				MembersVO members = new MembersVO();
				members.setmNo(rs.getInt("member_no"));
				members.setmName(rs.getString("member_name"));
				members.setmPw(rs.getString("member_pw"));
				members.setbDay(rs.getInt("birth_day"));
				members.setGender(rs.getString("member_gender"));
				members.setAddress(rs.getString("address"));
				members.setContact(rs.getString("contact"));
				members.setmRole(rs.getInt("role"));
				list.add(members);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	@Override
	public List<MembersVO> viewMs(MembersVO msVO) {
		List<MembersVO> list = new ArrayList<>();
		try {
			connect();
			stmt = conn.createStatement();

			String sql = "SELECT * FROM member_management WHERE member_name = '" + msVO.getmName() + "'";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				MembersVO members2 = new MembersVO();
				members2.setmNo(rs.getInt("member_no"));
				members2.setmName(rs.getString("member_name"));
				members2.setmPw(rs.getString("member_pw"));
				members2.setbDay(rs.getInt("birth_day"));
				members2.setGender(rs.getString("member_gender"));
				members2.setAddress(rs.getString("address"));
				members2.setContact(rs.getString("contact"));
				members2.setmRole(rs.getInt("role"));
				list.add(members2);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	@Override
	public void insertM(MembersVO msVO) {
		try {
			connect();
			String sql = "INSERT INTO member_management VALUES(?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, msVO.getmNo());
			pstmt.setString(2, msVO.getmName());
			pstmt.setString(3, msVO.getmPw());
			pstmt.setInt(4, msVO.getbDay());
			pstmt.setString(5, msVO.getGender());
			pstmt.setString(6, msVO.getAddress());
			pstmt.setString(7, msVO.getContact());
			pstmt.setInt(8, msVO.getmRole());

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("*정상적으로 등록되었습니다.*");
			} else {
				System.out.println("*정상적으로 등록되지 않았습니다.*");
			}
		} catch (Exception e) {
			System.out.println("*정상적으로 등록되지 않았습니다.*");
		} finally {
			disconnect();
		}
	}

	@Override
	public void updateM(MembersVO msVO) {
		try {
			connect();
			String sql = "UPDATE member_management SET address = ?, contact = ? WHERE member_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, msVO.getAddress());
			pstmt.setString(2, msVO.getContact());
			pstmt.setInt(3, msVO.getmNo());

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("정상적으로 수정됐습니다.");
			} else {
				System.out.println("*정상적으로 수정되지 않았습니다.*");
			}
		} catch (NullPointerException n) {
			System.out.println("회원번호가 일치하지 않습니다."); // 다른 정보라 null값으로 들어갔을때
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	@Override
	public void deleteM(int mNo) {
		try {
			connect();
			stmt = conn.createStatement();
			String sql = "DELETE FROM member_management WHERE member_no = " + mNo;
			int result = stmt.executeUpdate(sql);
			if (result > 0) {
				System.out.println("정상적으로 삭제됐습니다.");
			} else {
				System.out.println("*정상적으로 삭제되지 않았습니다.*");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	// 회원인지 확인
	@Override
	public MembersVO confirmM(MembersVO msVO) {
		MembersVO inputInfo = null;
		try {
			connect();
			String sql = "SELECT * FROM member_management WHERE member_no = " + msVO.getmNo();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				// 회원번호 존재할 때, 비밀번호도 맞는지 확인. 맞으면 no,pw,role 넣어서 보내주기
				if (rs.getString("member_pw").equals(msVO.getmPw())) {

					inputInfo = new MembersVO();
					inputInfo.setmNo(rs.getInt("member_no"));
					inputInfo.setmPw(rs.getString("member_pw"));
					inputInfo.setmRole(rs.getInt("role"));
				} else { // 아아디는 맞고 비번 틀렸을때 안내문 2번 출력돼서 여기꺼 없앰
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {

		} finally {
			disconnect();
		}
		return inputInfo;
	}
}
