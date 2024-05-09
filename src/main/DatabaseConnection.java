
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverMananger;

public class DataBaseConnection {
    public Connection databaseLink;

    public connection getConnection(){
        String databaseName = " java_project_";
        String databaseUser = "";
        String databasePassword = "";
        String url = "jdbc:mysql://localhost:8001/" + databaseName;
        try{
            Class.forName("com.mysql.cj.jbdc.Driver");
            databaseLink = DriverManager
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}