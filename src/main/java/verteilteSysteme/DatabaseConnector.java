package verteilteSysteme;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by z003aknc on 10.03.2016.
 */
public class DatabaseConnector
{
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName("com.mysql.jdbc.Driver").newInstance();

        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.89.128/vorlesung?user=vorlesung&password=vorlesung");
    }
}
