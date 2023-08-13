package com.care.sc.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.care.sc.dto.LoginDTO;
import com.care.sc.dto.RegisterDTO;

@Repository
public class MemberDAO {
	/*
	 * 테이블은 sc 라는 이름으로 만들어주세요 컬럼은 id, pw, name 세 개의 컬럼을 만들어주세요 사이즈는 자유, id는 primary
	 * key
	 * 
	 * 데이터를 직접 명령으로 입력하세요. id : admin pw : 1234 name : 관리자
	 * 
	 * SQL> CREATE TABLE sc ( 2 id varchar2(10), 3 pw varchar2(10), 4 name
	 * varchar2(20), 5 PRIMARY KEY(id) 6 );
	 * 
	 * 테이블이 생성되었습니다.
	 * 
	 * SQL> INSERT INTO sc VALUES('admin','1234','관리자'); 1 개의 행이 만들어졌습니다.
	 * 
	 * SQL> COMMIT;
	 * 
	 */
	private Connection con;

	public MemberDAO() {
		// 데이터베이스 드라이버 로드
		// 데이터베이스 연결해서 로그인
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "spring0115";
		String password = "oracle";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public RegisterDTO login(String id) {
		String sql = "SELECT * FROM sc WHERE id=?";

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				RegisterDTO login = new RegisterDTO();
				login.setId(id);
				login.setPw(rs.getString("pw"));
				login.setName(rs.getString("name"));
				return login;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public int register(RegisterDTO reg) {
		String sql = "INSERT INTO sc VALUES(?,?,?)";
		int rowCount = 0;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, reg.getId());
			ps.setString(2, reg.getPw());
			ps.setString(3, reg.getName());

			rowCount = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
	}

	public ArrayList<RegisterDTO> list() {

		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<RegisterDTO> members = new ArrayList<>();
		try {
			ps = con.prepareStatement("SELECT * FROM sc");
			rs = ps.executeQuery();
			while (rs.next()) {
				RegisterDTO reg = new RegisterDTO();
				reg.setId(rs.getString("id"));
				reg.setPw(rs.getString("pw"));
				reg.setName(rs.getString("name"));
				members.add(reg);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return members;
	}
	
	public void update(RegisterDTO reg) {
		
		int rowCount = 0;
		PreparedStatement ps = null;
		String sql = "";
		try {
			if(reg.getPw() == "") {
				sql = "UPDATE sc SET name=? WHERE id=?";
				ps = con.prepareStatement(sql);
				ps.setString(1, reg.getName());
				ps.setString(2, reg.getId());
			}
			else if(reg.getName() == "") {
				sql = "UPDATE sc SET pw=? WHERE id=?";
				ps = con.prepareStatement(sql);
				ps.setString(1, reg.getPw());
				ps.setString(2, reg.getId());
			}else {
				sql = "UPDATE sc SET pw=?, name=? WHERE id=?";
				ps = con.prepareStatement(sql);
				ps.setString(1, reg.getPw());
				ps.setString(2, reg.getName());
				ps.setString(3, reg.getId());
			}
			rowCount = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void delete(String id) {
		String sql = "DELETE FROM sc WHERE id=?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
















