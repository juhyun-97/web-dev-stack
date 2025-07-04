package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.ServerInfo;
import vo.Book;

public class BookDAO {
	
	private static BookDAO instance = new BookDAO();
	
	private BookDAO() {
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
	 // 1. 전체 책 조회
	public ArrayList<Book> printBookAll() throws SQLException {
	
		Connection connect = getConnect();
		
		String query = "SELECT * FROM book";
		PreparedStatement ps = connect.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		List<Book> list = new ArrayList<>();
		while (rs.next()) {
			Book book = new Book(rs.getInt("book_no"), rs.getString("title"), rs.getString("author"), rs.getInt("access_age"));
			list.add(book);
		}
		
		close(rs, ps, connect);
		
		return (ArrayList<Book>) list;
	}
	
	
	// 2. 책 등록
	public void registerBook(String title, String author, int accessAge) throws SQLException {
		
		Connection connect = getConnect();
		
		String query = "INSERT INTO book(title, author, access_Age VALUES(?, ?, ?)";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, title);
		ps.setString(2, author);
		ps.setInt(3, accessAge);
		
		ps.executeUpdate();
		
		close(ps, connect);
		
	}
	
	// 3. 책 삭제
	public void sellBook(int bookNo) throws SQLException {
		
		Connection connect = getConnect();
		
		String query = "DELETE FROM book WHERE book_no = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setInt(1, bookNo);
		
		int result = ps.executeUpdate();
		
		close(ps, connect);
	}
}
