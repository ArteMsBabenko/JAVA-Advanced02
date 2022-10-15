package Lesson_02.Lesson_02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

public class DAOFACTORY {
	
	private static DAOFACTORY instance;
	private Connection connection;

	private String url = "jdbc:mysql://localhost/online_shop?serverTimezone=" + TimeZone.getDefault().getID();
	private String user = "Artem";
	private String password = "44637567";

	private DAOFACTORY() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("Database driver class can't be found!" + e);
		} catch (SQLException e) {
			System.out.println("Database connection creation failed!" + e);
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public static DAOFACTORY getInstance() {
		if (instance == null) {
			instance = new DAOFACTORY();
		} else
			try {
				if (instance.getConnection().isClosed()) {
					instance = new DAOFACTORY();
				}
			} catch (SQLException e) {
				System.out.println("Database access error!" + e);
			}

		return instance;
	}

}
