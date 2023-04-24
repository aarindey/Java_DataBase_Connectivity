import java.sql.*;
import java.io.*;

public class InputInsert {
    public static void main(String args[]) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/students";

            String username = "root";
            String password = "root";

            Connection con = DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO students(StudentName,City) values (?,?)";
            PreparedStatement pstmt = con.prepareStatement(query);

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter Name To Be Inserted : ");
            String name = br.readLine();
            System.out.println("Enter City : ");
            String city = br.readLine();
            pstmt.setString(1, name);
            pstmt.setString(2, city);
            pstmt.executeUpdate();

            System.out.println("Successfully Inserted");

            System.out.println("Inserted...");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
