package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;
import vo.Member;

public class MemberDAO {
	
	private static MemberDAO instance = new MemberDAO();
	
	private MemberDAO() {
		try {
			
			Class.forName(ServerInfo.DRIVER);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	public Connection getConnect() throws SQLException { 
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
	}
	
	public void close(PreparedStatement ps, Connection connect) throws SQLException {
		ps.close();
		connect.close();
	}

	public void close(ResultSet rs, PreparedStatement ps, Connection connect) throws SQLException {
		rs.close();
		close(ps, connect);
	}
	// 4. 회원가입
	public String register(Member member) throws SQLException {
		
		Connection connect = getConnect();
		
		String query = "INSERT INTO member VALUES(?, ?, ?, ?)";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, member.getId());
		ps.setString(2, member.getName());
		ps.setString(3, member.getPwd());
		ps.setInt(4, member.getAge());
		
		ps.executeUpdate();
		
		close(ps, connect);
		
		return member.getName() + "님 회원가입 완료되었습니다!";
	}
	
	// 5. 로그인
	public Member login(String id, String pwd) throws SQLException {
		
		Connection connect = getConnect();
		
		String query = "INSERT INTO member(id, pwd) VALUES(?, ?)";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, id);
		ps.setString(2, pwd);
		
		ps.executeUpdate();
		
		close(ps, connect);
		
		
		return null;
	}
	
	// 6. 회원탈퇴
	public void delete(String id) throws SQLException {
		
		Connection connect = getConnect();
		
		String query = "DELETE FROM member WHERE id = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, id);
		
		int result = ps.executeUpdate();
		
		close(ps, connect);
	}
}
