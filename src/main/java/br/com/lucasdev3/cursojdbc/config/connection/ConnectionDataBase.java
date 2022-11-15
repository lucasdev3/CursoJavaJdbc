package br.com.lucasdev3.cursojdbc.config.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDataBase {

    public static Connection getConnection() {
        try {
            final String uri = "jdbc:mysql://localhost:3306/CURSO_JAVA";
            final String user = "root";
            final String password = "";
            return DriverManager.getConnection(uri, user, password);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
