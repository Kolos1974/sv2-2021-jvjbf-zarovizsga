package webshop;

import org.flywaydb.core.Flyway;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/exam-test?useUnicode=true");
            dataSource.setUser("root");
            dataSource.setPassword("root");
        }catch (SQLException sqle){
            throw new IllegalStateException("Cannot reach DataBase!", sqle);
        }

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        //Flyway flyway = Flyway.configure().locations("src/test/resources/db/migration").dataSource(dataSource).load();
        //flyway.clean();
        flyway.migrate();


    }

}
