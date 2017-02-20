/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.servlet.http.HttpSession;

@WebServlet(name = "SeguirServlet", urlPatterns = {"/seguir"})
public class SeguirServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // obtendo parametros do request 
        String in = request.getParameter("id_in");
        String out = request.getParameter("id_out");

        usuarioDAO dao = new usuarioDAO();
        dao.seguir(Integer.parseInt(in), Integer.parseInt(out));   // salva no BD

        String redirectURL = "usuario.jsp?id=" + in;
        response.sendRedirect(redirectURL);

    }
    
}
