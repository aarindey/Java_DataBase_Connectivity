import java.sql.*;

public class preparedStatement {
    public static void main(String args[]) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/students";

            String username = "root";
            String password = "root";

            Connection con = DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO students(StudentName,City) values (?,?)";
            PreparedStatement pstmt = con.prepareStatement(query);

            // Setting values to query
            pstmt.setString(1, "Aarin Dey");
            pstmt.setString(2, "Kochbehar");

            pstmt.executeUpdate();

            System.out.println("Inserted...");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
