package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Member;

// 드라이버로딩 기존 방식으로 하면 안되고 src -> main-> webapp -> WEB-INF -> lib폴더에 d드라이브에 있는것 그대로 끓어넣어야함.
public class MemberDAO {
	
	public MemberDAO() {
		// 1. 드라이버 로딩
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	public Connection connect() throws SQLException {
		// 2. 디비 연결
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/work", "root", "qwer1234");
	}
	
	public void register(Member member) throws SQLException {
		Connection connect = connect();
		
		String query = "INSERT INTO member VALUES(?, ?, ?, ?)";
		PreparedStatement ps = connect.prepareStatement(query);
		
		ps.setString(1, member.getId());
		ps.setString(2, member.getName());
		ps.setString(3, member.getPwd());
		ps.setInt(4, member.getAge());
		
		ps.executeUpdate();
		
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


}	
	
