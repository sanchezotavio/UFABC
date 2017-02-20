/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.usuarioDAO;
import javax.servlet.http.HttpSession;
import com.conta.usuario;
import com.sun.faces.action.RequestMapping;

public class EntrarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // obtendo parametros do request 
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        //autenticar usuário
        if (new usuarioDAO().autenticarConta(email, senha)) {
            // cria session e redireciona para página do usuário
            HttpSession session = request.getSession();
            usuario autenticado = new usuarioDAO().autenticarUsuario(email);
            session.setAttribute("usuario", autenticado);
            String redirectURL = "usuario.jsp?id=" + autenticado.getID();
            response.sendRedirect(redirectURL);
        } else {
            String redirectURL = "index.jsp?erro=1";
            response.sendRedirect(redirectURL);
        }

    }

}
