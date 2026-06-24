import java.sql.*;
import java.sql.DriverManager;
class Connectionclass {
    Connection con;
    Statement stm;
    Connectionclass() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/foodie_db", "root", "ummeruman895");
            stm = con.createStatement();
            System.out.println("Connection Successful!");
        } catch (Exception e) {
            System.out.println("Connection Failed. Check your password or database name.");
            e.printStackTrace();
        }
    }
}
    public class SqlConnection{
   public  static void main(String[] args) {
new Connectionclass();
    }
}
