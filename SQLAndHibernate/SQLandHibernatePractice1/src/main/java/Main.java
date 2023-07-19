import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/courses";
        String user = "root";
        String pass = "9449259";
        Connection connection = DriverManager.getConnection(url, user, pass);
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select p.course_name, " +
                "count(p.subscription_date) / (max(month(p.subscription_date)) - min(month(p.subscription_date)) + 1)" +
                "from purchaselist p group by p.course_name;");
        String format = "%-" + 80 + "s";
        System.out.printf(format, "Название курса");
        System.out.println("Среднее количество в месяц");
        while (resultSet.next()) {
            System.out.printf(format, resultSet.getString("p.course_name"));
            System.out.println(resultSet.getFloat ("count(p.subscription_date) / " +
                    "(max(month(p.subscription_date)) - min(month(p.subscription_date)) + 1)"));
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}