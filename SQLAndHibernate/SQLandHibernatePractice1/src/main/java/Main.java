import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        String url = "jdbs:mysql://localhost:3036/courses";
        String user = "root";
        String pass = "9449259";
        Connection connection = DriverManager.getConnection(url, user, pass);
        Statement statement = connection.createStatement();
        System.out.println(statement.executeQuery("Select * from courses"));

    }
}
