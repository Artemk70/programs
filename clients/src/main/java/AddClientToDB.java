import java.sql.*;

public class AddClientToDB {
    private final String URL = "jdbc:mysql://localhost:3306/shop";
    private final String USER = "root";
    private final String PASS = "eaHo34!390Ssvl";

    Connection connection = DriverManager.getConnection(URL, USER, PASS);

    public AddClientToDB() throws SQLException {
    }

    public void addToDB(Client client) {
        String addTable = "CREATE TABLE clients (" +
                "id INT AUTO_INCREMENT, " +
                "name VARCHAR(50) NOT NULL, " +
                "birthday DATE NOT NULL, " +
                "phone VARCHAR(15) NOT NULL, " +
                "eMail VARCHAR(50), " +
                "PRIMARY KEY(id)" +
                ")";

        String dropTable = "DROP TABLE IF EXISTS clients";

        String addClient = "INSERT INTO clients(name, birthday, phone, eMail) VALUES(?, ?, ?, ?)";
        try {


//            connection.createStatement().execute(dropTable);
//            connection.createStatement().execute(addTable);

            PreparedStatement preparedStatement = connection.prepareStatement(addClient);
            preparedStatement.setString(1, client.getName());
            preparedStatement.setDate(2, client.getBirthday());
            preparedStatement.setString(3, client.getPhoneNumber());
            preparedStatement.setString(4, client.geteMail());

            preparedStatement.executeUpdate();
            preparedStatement.close();

            preparedStatement = connection.prepareStatement("SELECT * FROM clients");
            ResultSet resultSet = preparedStatement.executeQuery();

            StringBuilder builder = new StringBuilder();
            while (resultSet.next()) {
                builder.append(resultSet.getString("name") + "\n");
                builder.append(resultSet.getDate("birthday") + "\n");
                builder.append(resultSet.getString("phone") + "\n");
                builder.append(resultSet.getString("eMail") + "\n");
            }
            System.out.println(builder.toString());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addTable() throws SQLException{
        String addTable = "CREATE TABLE clients (" +
                "id INT AUTO_INCREMENT, " +
                "name VARCHAR(50) NOT NULL, " +
                "birthday DATE NOT NULL, " +
                "phone VARCHAR(15) NOT NULL, " +
                "eMail VARCHAR(50), " +
                "PRIMARY KEY(id)" +
                ")";

        connection.createStatement().execute(addTable);
    }

    public void dropTable() throws SQLException{
        connection.createStatement().execute("DROP TABLE IF EXISTS clients");
    }

}
