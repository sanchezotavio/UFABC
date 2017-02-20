package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.conta.usuario;
import com.conta.post;
import com.dao.usuarioDAO;
import com.jdbc.ConnectionFactory;
import java.text.SimpleDateFormat;
import java.util.Date;

public class usuarioDAO {

    private Connection connection;

    public usuarioDAO() {
        // criar uma conexao com o BD
        this.connection = new ConnectionFactory().getConnection();
    }

    public void fechaConexao() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // insere um novo usuário 
    public void insere(usuario usuario) {
        String sql = "insert into usuario (nome,email,senha,descricao,imagem) values (?,?,?,?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            // seta valores
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getDescricao());
            stmt.setString(5, usuario.getImagem());
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // remove usuário
    public void remove(usuario usuario) {
        try {
            PreparedStatement stmt = connection.prepareStatement("delete from usuario where id=?");
            stmt.setLong(1, usuario.getID());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // altera dados de um usuário
    public void alterarUsuario(usuario usuario) {
        String sql = "update usuario set nome=?, descricao=?, imagem=? where id=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getDescricao());
            stmt.setString(3, usuario.getImagem());
            stmt.setLong(4, usuario.getID());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void alterarVisualizacao(String id, int visualizacao) {
        String sql = "update usuario set visualizacoes=? where id=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, visualizacao);
            stmt.setString(2, id);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String descricaoUsuario(String ID) {

        String sql = "select descricao from usuario where ID=?";

        String Descricao = null;

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, ID);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            Descricao = rs.getString("descricao");
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (Descricao == null || Descricao == "") {
            Descricao = "Sem descrição.";
        }

        return Descricao;
    }

    public String imgUsuario(String ID) {

        String sql = "select imagem from usuario where ID=?";

        String img = null;

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, ID);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            if (rs.getString("imagem") == null || rs.getString("imagem") == "") {
                img = "img-usuario/default.jpg";
            } else {
                img = rs.getString("imagem");
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return img;

    }

    public String nomeUsuario(String ID) {

        String sql = "select nome from usuario where ID=?";

        String Nome = null;

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, ID);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            Nome = rs.getString("nome");
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Nome;

    }

    // fazer busca de usuários(s) pelo nome
    public List<usuario> buscaUsuarioPeloNome(String nome) {
        List<usuario> u = new ArrayList<usuario>();

        PreparedStatement stmt;
        String sql = "select * from usuario where nome=?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                usuario usuario = new usuario();
                usuario.setId(rs.getLong("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setDescricao(rs.getString("descricao"));
                usuario.setImagem(rs.getString("imagem"));
                u.add(usuario);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return u;
    }

    // fazer busca de usuários(s) pelo ID
    public List<usuario> buscaUsuarioPeloID(long ID) {
        List<usuario> u = new ArrayList<usuario>();

        PreparedStatement stmt;
        String sql = "select * from usuario where ID=?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setLong(1, ID);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                usuario usuario = new usuario();
                usuario.setId(rs.getLong("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setDescricao(rs.getString("descricao"));
                usuario.setImagem(rs.getString("imagem"));
                u.add(usuario);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return u;
    }

    // devolve uma lista com todos os usuários
    public List<usuario> getLista() {
        List<usuario> u = new ArrayList<usuario>();

        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("select * from usuario order by nome");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                usuario usuario = new usuario();
                usuario.setId(rs.getLong("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setDescricao(rs.getString("descricao"));
                usuario.setDescricao(rs.getString("imagem"));
                u.add(usuario);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return u;
    }

    public List<usuario> getListaTop() {
        List<usuario> u = new ArrayList<usuario>();

        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("select * from usuario order by visualizacoes desc");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                usuario usuario = new usuario();
                usuario.setId(rs.getLong("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setDescricao(rs.getString("descricao"));
                usuario.setDescricao(rs.getString("imagem"));
                u.add(usuario);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return u;
    }

    // devolve uma lista com todos os usuários
    public List<usuario> getBusca(String busca) {
        List<usuario> u = new ArrayList<usuario>();

        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("select * from usuario where nome like '%" + busca + "%' ");

            ResultSet rs = stmt.executeQuery();

            String img = null;
            String descricao = "";

            while (rs.next()) {

                if (rs.getString("imagem") == null || rs.getString("imagem") == "") {
                    img = "img-usuario/default.jpg";
                } else {
                    img = rs.getString("imagem");
                }

                if (rs.getString("descricao") == null || rs.getString("descricao") == "") {
                    descricao = "Sem decrição";
                } else {
                    descricao = rs.getString("descricao");
                }

                usuario usuario = new usuario();
                usuario.setId(rs.getLong("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setDescricao(descricao);
                usuario.setImagem(img);
                u.add(usuario);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return u;
    }

    // devolve uma lista com todos os usuários que ele está seguindo
    public List<usuario> getSeguindo(String in) {
        List<usuario> u = new ArrayList<usuario>();

        PreparedStatement stmt;
        try {

            String sql = "select * from seguidor as s inner join usuario as u on s.id_out=? and u.id  = s.id_in";

            stmt = connection.prepareStatement(sql);

            stmt.setString(1, in);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                usuario usuario = new usuario();
                usuario.setId(rs.getLong("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setDescricao(rs.getString("descricao"));
                usuario.setDescricao(rs.getString("imagem"));
                u.add(usuario);
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return u;
    }

    // devolve uma lista com todos os usuários que ele é seguido
    public List<usuario> getSeguido(String in) {
        List<usuario> u = new ArrayList<usuario>();

        PreparedStatement stmt;
        try {

            String sql = "select * from seguidor as s inner join usuario as u on s.id_in=? and s.id_out = u.id";

            stmt = connection.prepareStatement(sql);

            stmt.setString(1, in);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                usuario usuario = new usuario();
                usuario.setId(rs.getLong("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setDescricao(rs.getString("descricao"));
                usuario.setDescricao(rs.getString("imagem"));
                u.add(usuario);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return u;
    }

    // devolve uma lista com todos os usuários que ele é seguido
    public List<post> getPost(String id) {
        List<post> u = new ArrayList<post>();

        PreparedStatement stmt;
        try {

            String sql = "select * from post where id_usuario=? order by idpost desc";

            stmt = connection.prepareStatement(sql);

            stmt.setString(1, id);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                post postagem = new post();
                postagem.setUsuario(rs.getInt("id_usuario"));
                postagem.setPost(rs.getString("post"));
                postagem.setData(rs.getString("data"));
                postagem.setHora(rs.getString("hora"));
                u.add(postagem);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return u;
    }

    public List<post> getPostTime(String id) {
        List<post> u = new ArrayList<post>();

        PreparedStatement stmt;
        try {

            String sql = "select * from post where id_usuario=? union SELECT *  FROM post WHERE id_usuario IN ( SELECT id_out FROM seguidor AS s INNER JOIN usuario AS u ON s.id_in =? AND s.id_out = u.id ) ORDER BY idpost DESC";

            stmt = connection.prepareStatement(sql);

            stmt.setString(1, id);
            stmt.setString(2, id);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                post postagem = new post();
                postagem.setUsuario(rs.getInt("id_usuario"));
                postagem.setPost(rs.getString("post"));
                postagem.setData(rs.getString("data"));
                postagem.setHora(rs.getString("hora"));
                u.add(postagem);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return u;
    }

    public boolean autenticarConta(String email, String senha) {

        try {
            PreparedStatement stmt = this.connection.prepareStatement("select * from usuario where email=? and senha=?");
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

    public void seguir(int in, int out) {

        String sql = "insert into seguidor (id_in,id_out) values (?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            // seta valores
            stmt.setInt(1, in);
            stmt.setInt(2, out);
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void postar(String id_usuario, String post) {

        String sql = "insert into post (id_usuario,post,data,hora) values (?,?,?,?)";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);

            Date data = new Date();
            SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat hr = new SimpleDateFormat("HH:mm");

            // seta valores
            stmt.setString(1, id_usuario);
            stmt.setString(2, post);
            stmt.setString(3, ft.format(data));
            stmt.setString(4, hr.format(data));
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean seguindo(String in, String out) {

        try {
            PreparedStatement stmt = this.connection.prepareStatement("select * from seguidor where id_in=? and id_out=?");
            stmt.setString(1, in);
            stmt.setString(2, out);
            ResultSet rs = stmt.executeQuery();

            boolean encontrado = rs.next();
            rs.close();
            stmt.close();

            return encontrado;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public int contar(String id, int tipo) {

        int total = 0;
        PreparedStatement stmt;
        ResultSet rs;

        try {
            switch (tipo) {
                case 1:
                    stmt = this.connection.prepareStatement("select count(*) from  post where id_usuario=?");
                    stmt.setString(1, id);
                    rs = stmt.executeQuery();

                    if (rs.next()) {
                        int numberOfRows = rs.getInt(1);
                        total = numberOfRows;
                    }

                    rs.close();
                    stmt.close();
                    break;
                case 2:
                    stmt = this.connection.prepareStatement("select count(*) from  seguidor where id_in=?");
                    stmt.setString(1, id);
                    rs = stmt.executeQuery();

                    if (rs.next()) {
                        int numberOfRows = rs.getInt(1);
                        total = numberOfRows;
                    }

                    rs.close();
                    stmt.close();
                    break;
                case 3:
                    stmt = this.connection.prepareStatement("select count(*) from  seguidor where id_out=?");
                    stmt.setString(1, id);
                    rs = stmt.executeQuery();

                    if (rs.next()) {
                        int numberOfRows = rs.getInt(1);
                        total = numberOfRows;
                    }

                    rs.close();
                    stmt.close();
                    break;

                case 4:
                    stmt = this.connection.prepareStatement("select visualizacoes from usuario where id=?");
                    stmt.setString(1, id);
                    rs = stmt.executeQuery();

                    if (rs.next()) {
                        total = rs.getInt("visualizacoes");
                        total++;
                        alterarVisualizacao(id, total);
                    }

                    rs.close();
                    stmt.close();
                    break;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return total;
    }

    public usuario autenticarUsuario(String email) {

        usuario autenticado = new usuario();

        try {
            PreparedStatement stmt = this.connection.prepareStatement("select * from usuario where email=?");
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            rs.next();
            autenticado.setId(rs.getLong("id"));
            autenticado.setNome(rs.getString("nome"));
            autenticado.setEmail(rs.getString("email"));
            autenticado.setDescricao(rs.getString("descricao"));
            autenticado.setDescricao(rs.getString("imagem"));

            rs.close();
            stmt.close();

            return autenticado;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
