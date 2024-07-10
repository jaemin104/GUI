package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbBasic {
	private static Connection conn;

	public static Connection init() {
		
		try {
			// db 드라이버 설치
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// db 연결
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db?serverTimezone=UTC", "root", "woals1973");
			
			System.out.println("ok");
			
			return conn;
			
		} catch (Exception e) {
			return null;
		}
	}
}
