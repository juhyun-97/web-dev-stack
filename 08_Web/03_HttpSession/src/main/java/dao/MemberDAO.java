package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Member;

public class MemberDAO {
	
	public MemberDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	public Connection connect() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/work", "root", "qwer1234");
	}
	
	public void register(Member member) throws SQLException {
		Connection connect = connect();
		
		String query = "INSERT INTO member VALUES(?, ?, ? ,?)";
		PreparedStatement ps = connect.prepareStatement(query);
		
		ps.setString(1, member.getId());
		ps.setString(2, member.getName());
		
		ps.executeUpdate();
		
	}

	public Member search(String id) throws SQLException {
		Connection connect = connect();
		
		String query = "SELECT * FROM member WHERE id = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		Member member = null;
		if(rs.next()) {
			member = new Member(rs.getString("id"), rs.getString("name"), rs.getString("pwd"), rs.getInt("age"));
		}
		return member;
	}
	
	public List<Member> viewAll() throws SQLException {
		Connection connect = connect();
		
		String query = "SELECT * FROM member";
		PreparedStatement ps = connect.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		List<Member> list = new ArrayList<>();
		
		while(rs.next()) {
			Member member = new Member();
			member.setId(rs.getString("id"));
			member.setPwd(rs.getString("pwd"));
			member.setName(rs.getString("name"));
			member.setAge(rs.getInt("age"));
			list.add(member);
		}
		return list;
	}
	

}	