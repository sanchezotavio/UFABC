package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.conta.usuario;
import com.dao.usuarioDAO;

@WebServlet(name = "InsereServlet", urlPatterns = {"/insere"})
public class InsereServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        // obtendo parametros do request 
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String descricao = request.getParameter("descricao");
        String imagem = request.getParameter("imagem");

        // instancia objeto usuario
        usuario usuario = new usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setDescricao(descricao);
        usuario.setImagem(imagem);

        usuarioDAO dao = new usuarioDAO();
        dao.insere(usuario);   // salva no BD

        // cria session e redireciona para página do usuário
        HttpSession session = request.getSession();
        usuario autenticado = new usuarioDAO().autenticarUsuario(email);
        session.setAttribute("usuario", autenticado);
        String redirectURL = "usuario.jsp?id=" + autenticado.getID();
        response.sendRedirect(redirectURL);
    }

    @Override
    public String getServletInfo() {
        return "Inserir campos";
    }

}
