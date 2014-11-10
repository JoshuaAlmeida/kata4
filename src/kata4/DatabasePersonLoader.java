package kata4;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class DatabasePersonLoader implements PersonLoader{
    private final Connection conection;

    public DatabasePersonLoader(Connection conection) {
        this.conection = conection;
    }

    @Override
    public Person[] load() {
        try {
           return processQuery(conection.createStatement().executeQuery("SELECT * FROM people"));
           
        } catch (SQLException ex) {
            Logger.getLogger(DatabasePersonLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Person[0];
    }

    private Person[] processQuery(ResultSet resultSet) throws SQLException{
        ArrayList<Person> personList = new ArrayList<>();
        while(resultSet.next()){
            personList.add(proccesPerson(resultSet));
        }
        return personList.toArray(new Person[personList.size()]);
    }

    private Person proccesPerson(ResultSet resultSet) throws SQLException {
        return new Person( resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("company_name"),
                        resultSet.getString("address"),
                        resultSet.getString("city"),
                        resultSet.getString("state"),
                        new Mail(resultSet.getString("email")),
                        resultSet.getString("web"));
    }

}
