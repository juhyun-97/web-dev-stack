package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import config.ServerInfo;

public class DBConnectionTest3 {
	
	public static void main(String[] args) {

		try {
			// 1. 드라이버 로딩
			Class.forName(ServerInfo.DRIVER);
			
			// 2. DB 연결
			Connection connect = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
			
			// 3. PreparedStatement - 쿼리 : UPDATE (user_no를 선택해서 email 수정)
			String query = "UPDATE user_info SET email = ? WHERE user_no = ?";
			PreparedStatement ps = connect.prepareStatement(query);
			
			ps.setString(1, "test2@google.com"); // 이미 값이 mysql에 있는 경우면 값 수정후 넣어야만 함(duplicate)
			ps.setInt(2, 4);
			
			// 4. 쿼리문 실행 - excuteUpdate
			System.out.println(ps.executeUpdate() + "명 수정!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
	}

}
