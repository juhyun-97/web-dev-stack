package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.ServerInfo;
import vo.Rent;

public class RentDAO {

	private RentDAO() {
		try {

			Class.forName(ServerInfo.DRIVER);

		} catch (Exception e) {
			e.printStackTrace();
		}
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

	// 7. 책 대여
	public void rentBook(String id, int bookNo) throws SQLException {

		Connection connect = getConnect();

		String query = "SELECT * FROM rent WHERE id = ?, book_no = ?";
		PreparedStatement ps = connect.prepareStatement(query);

		ps.setString(1, id);
		ps.setInt(2, bookNo);

		ResultSet rs = ps.executeQuery();

		close(rs, ps, connect);
	}

	// 8. 내가 대여한 책 조회
	public ArrayList<Rent> printRentBook(String id) throws SQLException {

		Connection connect = getConnect();

		String query = "SELECT * FROM rent WHERE id = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, id);

		ResultSet rs = ps.executeQuery();
		List<Rent> list = new ArrayList<>();

		return (ArrayList<Rent>) list;
	}

	// 9. 대여 취소
	public void deleteRent(int rentNo) throws SQLException {

		Connection connect = getConnect();

		String query = "DELETE FROM rent WHERE rent_no = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setInt(1, rentNo);

		int result = ps.executeUpdate();

		close(ps, connect);
	}
}
