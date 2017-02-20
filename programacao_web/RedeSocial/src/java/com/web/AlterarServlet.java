package com.web;

import com.conta.usuario;
import com.dao.usuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sanchez
 */
@WebServlet(name = "AlterarServlet", urlPatterns = {"/alterar"})
public class AlterarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // obtendo parametros do request 
        int id_usuario = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        String imagem = request.getParameter("imagem");

        usuario usuario = new usuario();
        usuario.setId(id_usuario);
        usuario.setNome(nome);
        usuario.setDescricao(descricao);
        usuario.setImagem(imagem);
        usuarioDAO dao = new usuarioDAO();
        dao.alterarUsuario(usuario);   // altera no BD

        String redirectURL = "usuario.jsp?id=" + id_usuario;
        response.sendRedirect(redirectURL);

    }

}
