package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import config.ServerInfo;
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
		return DriverManager.getConnection("jdbc:mysqlL//localhost:3306/work", "root", "qwer1234");
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
	
}	
	
