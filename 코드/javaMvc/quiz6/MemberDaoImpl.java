package com.care.javaMvc.quiz6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDaoImpl implements IMemberDAO{
	private Connection con;
	
	public MemberDaoImpl() {
		// 디비에 찾아가서 로그인
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
	
	@Override
	public void insert(MemberDTO member) {
		String sql = "INSERT INTO java_basic VALUES(?,?,?)";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getId());
			ps.setString(2, member.getPassword());
			ps.setString(3, member.getName());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public MemberDTO selectId(String id) {
		String sql = "SELECT * FROM java_basic WHERE id=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				MemberDTO member = new MemberDTO();
				member.setId(rs.getString("id"));
				member.setPassword(rs.getString("password"));
				member.setName(rs.getString("name"));
				return member;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void delete(String id) {
		String sql = "DELETE FROM java_basic WHERE id=?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void update(MemberDTO updateMember) {
		String sql = "UPDATE java_basic SET password=? WHERE id=?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(2, updateMember.getId());
			ps.setString(1, updateMember.getPassword());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<MemberDTO> selectAll() {
		String sql = "SELECT * FROM java_basic";
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<MemberDTO> members = new ArrayList<MemberDTO>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				MemberDTO member = new MemberDTO();
				member.setId(rs.getString("id"));
				member.setPassword(rs.getString("password"));
				member.setName(rs.getString("name"));
				members.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return members;
	}


}





