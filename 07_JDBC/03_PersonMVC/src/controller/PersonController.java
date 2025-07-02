package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;

public class PersonController {

	// 리턴 타입이나 파라미터 자유롭게 변경 가능!
	// 메서드 추가 가능!

	public PersonController() {
		try {
			// 1. 드라이버로딩
			Class.forName(ServerInfo.DRIVER);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 고정적으로 반복
	// 2. 디비 연결
	public Connection getConnect() throws SQLException {
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
	}

	// 오버로딩
	public void close(PreparedStatement ps, Connection connect) throws SQLException {
		ps.close();
		connect.close();
	}

	public void close(ResultSet rs, PreparedStatement ps, Connection connect) throws SQLException {
		rs.close();
		close(ps, connect);
	}

	// ------------------ 변동적인 반복 : DAO(Database Access Object)

	// person 테이블에 데이터 추가 - INSERT
	public void addPerson(String name, int age, String addr) throws SQLException {

		Connection connect = getConnect();

		// 3. PreparedStatement 객체 생성 - 쿼리
		String query1 = "INSERT INTO person VALUES(?, ?, ?, ?)";
		PreparedStatement ps = connect.prepareStatement(query1);
		ps.setString(1, "8");
		ps.setString(2, "김주현");
		ps.setString(3, "29");
		ps.setString(4, "경기 안산시");

		// 4. 쿼리 실행
		ps.executeUpdate();

		// 5. 자원 반납
		close(ps, connect);

	}

	// person 테이블에 있는 데이터 전체 보여주기 - SELECT
	public void searchAllPerson() throws SQLException {

		Connection connect = getConnect();

		String query1 = "SELECT * FROM person";
		PreparedStatement ps = connect.prepareStatement(query1);
		;

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			int personId = rs.getInt("id");
			String name = rs.getString("name");
			int age = rs.getInt("age");
			String addr = rs.getString("addr");
		}

		close(rs, ps, connect);
	}

	// person 테이블에서 데이터 한개만 가져오기 - SELECT -> id로!
	public void searchPerson() throws SQLException {
		Connection connect = getConnect();

		String query1 = "SELECT * FROM person WHERE id = ?";
		PreparedStatement ps = connect.prepareStatement(query1);
		ps.setInt(1, 2);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			int personId = rs.getInt("person_id");
		}

		close(rs, ps, connect);
	}

	// person 테이블에 데이터 수정 - UPDATE
	public void updatePerson() throws SQLException {

		Connection connect = getConnect();

		String query1 = "UPDATE person SET addr = ? WHERE name = ?";
		PreparedStatement ps = connect.prepareStatement(query1);
		ps.setString(1, "경기 성남시");
		ps.setString(2, "가나다");

		ps.executeUpdate();

		close(ps, connect);
	}

	// person 테이블에 데이터 삭제 - DELETE
	public void removePerson() throws SQLException {

		Connection connect = getConnect();

		String query1 = "DELETE FROM person WHERE id = ?";
		PreparedStatement ps = connect.prepareStatement(query1);
		ps.setInt(1, 3);

		ps.executeUpdate();

		close(ps, connect);
	}
}
