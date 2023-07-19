import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/courses";
        String user = "root";
        String pass = "pass";
        Connection connection = DriverManager.getConnection(url, user, pass);
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select p.course_name, " +
                "count(p.subscription_date) / (max(month(p.subscription_date)) - min(month(p.subscription_date)) + 1)" +
                "from purchaselist p group by p.course_name;");

        while (resultSet.next()) {
            String format = "%-" + 40 + "s"; // Выравнивание по левому краю
            System.out.printf(format, resultSet.getString("p.course_name"));
            System.out.println(resultSet.getFloat ("count(p.subscription_date) / " +
                    "(max(month(p.subscription_date)) - min(month(p.subscription_date)) + 1)"));
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}