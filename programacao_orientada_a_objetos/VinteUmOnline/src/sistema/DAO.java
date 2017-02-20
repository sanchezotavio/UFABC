package sistema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

/**
 *
 * @author Otávio
 */
public class DAO {

    private Connection connection;

    public DAO() {
        // criar uma conexao com o BD
        this.connection = new BD().getConexaoMySQL();
    }

    public int insereUsuario(String Usuario, String Email, String Senha) {
        String sql = "INSERT INTO Usuario(usuario, senha, email, id) VALUES (?,?,?,?)";
        Random n = new Random();
        int i = n.nextInt(9999999);

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            // seta valores
            stmt.setString(1, Usuario);
            stmt.setString(2, Senha);
            stmt.setString(3, Email);
            stmt.setString(4, String.valueOf(i));
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return i;
    }

    public int insereRodada(int id, int Resultado) {
        String sql = "INSERT INTO Partida(id_usuario,resultado) VALUES (?,?)";
        Random n = new Random();
        int i = n.nextInt(9999999);

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            // seta valores
            stmt.setInt(1, id);
            stmt.setInt(2, Resultado);
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return i;
    }
    
     public boolean autenticarConta(String email, String senha) {

        try {
            PreparedStatement stmt = this.connection.prepareStatement("select * from Usuario where email=? and senha=?");
            stmt.setString(1, email);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();

            boolean encontrado = rs.next();
            rs.close();
            stmt.close();

            return encontrado;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public int ID(String email) {

        try {
            PreparedStatement stmt = this.connection.prepareStatement("select * from Usuario where email=?");
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            rs.next();
            int ID = rs.getInt("id");
            rs.close();
            stmt.close();

            return ID;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public String nomeJogador(int ID) {

        try {
            PreparedStatement stmt = this.connection.prepareStatement("select * from Usuario where id=?");
            stmt.setString(1, String.valueOf(ID));
            ResultSet rs = stmt.executeQuery();

            rs.next();
            String Nome = rs.getString("usuario");
            rs.close();
            stmt.close();

            return Nome;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
