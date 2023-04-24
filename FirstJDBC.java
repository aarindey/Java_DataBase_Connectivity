
// Program for jdbc 1 Program
import java.sql.*;

class FirstJDBC {
	public static void main(String args[]) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/students";

			String username = "root";
			String password = "root";

			Connection con = DriverManager.getConnection(url, username, password);
			if (con.isClosed()) {
				System.out.println("Connection is Closed");
			} else {
				System.out.println("Connection is Created");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
