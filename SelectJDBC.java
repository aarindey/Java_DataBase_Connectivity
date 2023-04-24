import java.sql.*;
import java.io.*;

public class SelectJDBC {
    public static void main(String args[]) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/students";

            String username = "root";
            String password = "root";

            Connection con = DriverManager.getConnection(url, username, password);
            String query = "SELECT * from students";

            Statement stmt = con.createStatement();
            ResultSet set = stmt.executeQuery(query);

            while (set.next()) {
                int id = set.getInt(1);
                String name = set.getString(2);
                String city = set.getString(3);
                System.out.println(name);
                System.out.println(id);
                System.out.println(city);
            }

            System.out.println("Successful");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
