package sistema;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;

public class BD {

    public static String status = "Erro";

    public static java.sql.Connection getConexaoMySQL() {
        Connection connection = null;

        try {
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            String serverName = "mysql03.osanchez.hospedagemdesites.ws";
            String mydatabase = "osanchez2";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String username = "osanchez2";
            String password = "erroos921010";
            connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                status = ("Conectado com sucesso!");
            } else {
                status = ("Não foi possivel realizar conexão");
            }
            return connection;
        } catch (ClassNotFoundException e) {
            System.out.println("O driver expecificado nao foi encontrado.");
            return null;
        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            return null;
        }
    }

    public static String statusConection() {
        return status;
    }

    public static boolean FecharConexao() {
        try {
            BD.getConexaoMySQL().close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

}
