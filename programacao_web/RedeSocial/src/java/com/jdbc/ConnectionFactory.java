
package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection() {
        System.out.println("Conectando ao banco de dados");
        try {
            // Conexão com MySQL
            Class.forName("com.mysql.jdbc.Driver"); 
            String url = "jdbc:mysql://mysql01.osanchez.hospedagemdesites.ws/osanchez";
            return DriverManager.getConnection(url, "osanchez", "erroos921010");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
