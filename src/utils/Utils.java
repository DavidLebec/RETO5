package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utils {


    public static Connection getConnection(){
        String conString = "jdbc:mysql://localhost:3306/spacecraft?zeroDateTimeBehavior=convertToNull";
        String username = "root";
        String password = "3133482182Pe";
        try{
            return DriverManager.getConnection(conString, username, password);
        }catch(SQLException e){
            System.out.println("Error en la conexion: " + e.getMessage());
            return null;
        }
    }

}
