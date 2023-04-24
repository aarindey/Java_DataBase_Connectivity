import java.sql.*;

class InsertJDBC {
    public static void main(String args[]) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/students";

            String username = "root";
            String password = "root";

            Connection con = DriverManager.getConnection(url, username, password);
            String query = "CREATE TABLE Students(StudentID INT(20) primary key auto_increment,StudentName varchar(200) not null,City varchar(400))";
            Statement stmt = con.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Table is Created in Database....");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
