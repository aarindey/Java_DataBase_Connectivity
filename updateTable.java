import java.sql.*;
import java.io.*;

public class updateTable {
    public static void main(String args[]) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/students";

            String username = "root";
            String password = "root";

            Connection con = DriverManager.getConnection(url, username, password);
            String query = "UPDATE students set StudentName=?, City=? where StudentID=?";

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter New Name : ");
            String name = br.readLine();

            System.out.println("Enter New City : ");
            String city = br.readLine();

            System.out.println("Enter Student ID : ");
            int id = Integer.parseInt(br.readLine());

            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setString(1, name);
            pstmt.setString(2, city);

            pstmt.setInt(3, id);

            pstmt.executeUpdate();

            System.out.println("Successfully Updated");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
