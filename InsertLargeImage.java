import java.sql.*;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import java.io.*;

public class InsertLargeImage {
    public static void main(String args[]) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/students";

            String username = "root";
            String password = "root";

            Connection con = DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO images(pic) values(?)";
            PreparedStatement pstmt = con.prepareStatement(query);

            JFileChooser jfc = new JFileChooser();

            jfc.showOpenDialog(null);

            File file = jfc.getSelectedFile();

            FileInputStream fis = new FileInputStream(file);

            pstmt.setBinaryStream(1, fis, fis.available());

            pstmt.executeUpdate();

            System.out.println("Successfully Inserted");
            JOptionPane.showMessageDialog(null, "Successfully Inserted");
            // System.out.println("Inserted...");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
