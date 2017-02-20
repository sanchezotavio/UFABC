
package com.web;

import com.dao.usuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PostarServlet", urlPatterns = {"/postar"})
public class PostarServlet extends HttpServlet {

     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // obtendo parametros do request 
        String id_usuario = request.getParameter("id_usuario");
        String post = request.getParameter("post");

        usuarioDAO dao = new usuarioDAO();
        dao.postar(id_usuario, post);   // salva no BD

        String redirectURL = "usuario.jsp?id=" + id_usuario;
        response.sendRedirect(redirectURL);

    }
    
}
