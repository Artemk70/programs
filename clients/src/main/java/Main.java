import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Date birthDay = Date.valueOf(LocalDate.of(1900, 7, 20));

        Client client = new Client("Artem", birthDay, "+79876543210", "first@gmail.com");
        Client client2 = new Client("Oleg", birthDay, "+79876543210", "second@gmail.com");
        Client client3 = new Client("Maksim", birthDay, "+79876543210", "third@gmail.com");
        Client client4 = new Client("Olya", birthDay, "+79876543210", "fifth@gmail.com");

        AddClientToDB addClientToDB = null;

        try {
            addClientToDB = new AddClientToDB();
            addClientToDB.dropTable();
            addClientToDB.addTable();

            addClientToDB.addToDB(client);
            addClientToDB.addToDB(client2);
            addClientToDB.addToDB(client3);
            addClientToDB.addToDB(client4);

            addClientToDB.printDB();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
