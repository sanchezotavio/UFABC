<%@page import="java.util.List"%>
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->

    <%@ page import="com.dao.usuarioDAO" %>
    <%@ page import="com.conta.usuario" %>
    <%@ page import="com.conta.post" %> 

    <head>

        <%
            String id_usuario = request.getParameter("id");
            usuarioDAO dao = new usuarioDAO();
        %>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>

            oSocial |  <% out.print(dao.nomeUsuario(id_usuario)); %>

        </title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="apple-touch-icon.png">

        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="css/main.css">

        <script src="js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>

    </head>

    <body>

        <nav class="navbar bar-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <div class="container-fluid">
                        <a class="brand" href="index.jsp"></a>
                    </div>
                </div>
                <div id="navbar" class="navbar-collapse collapse">

                    <form class="navbar-form navbar-left" action="buscar.jsp" method="get">
                        <div class="input-group">
                            <span class="input-group-btn"><input type="text" placeholder="Buscar amigos" name="busca" class="form-control" required>
                                <button type="submit" class="btn btn-default" role="button">Buscar</button>
                            </span>
                        </div>
                    </form>

                    <%
                        if (request.getSession().getAttribute("usuario") == null) {
                    %>

                    <form class="navbar-form navbar-right" action="entrar" method="post" role="form">
                        <div class="form-group">
                            <input type="text" placeholder="Email" name="email" class="form-control">
                        </div>
                        <div class="form-group">
                            <input type="password" placeholder="Senha" name="senha" class="form-control">
                        </div>
                        <button type="submit" class="btn btn-success">Acessar</button>
                    </form>

                    <%
                    } else {
                    %>

                    <nav class="collapse navbar-collapse" >
                        <ul class="nav navbar-right navbar-nav">
                            <li>
                                <a href="usuario.jsp?id=${usuario.ID}">
                                    ${usuario.nome}
                                </a>
                            </li>
                            <li>
                                <a href="configuracoes.jsp">
                                    Configurações
                                </a>
                            </li>
                            <li>
                                <a href="logout">Sair</a>
                            </li>
                        </ul>
                    </nav>

                    <%
                        }
                    %>

                </div>
            </div>
        </nav>

        <div class="container">

            <div class="col-md-2 usuario">

                <div class="box">

                    <a href="usuario.jsp?id=<% out.print(id_usuario); %>"> 
                        <img class="img-responsive" src="<% out.print(dao.imgUsuario(id_usuario)); %>" title="<% out.print(dao.nomeUsuario(id_usuario)); %>" class="img-circle img-responsive" />
                    </a>

                    <h1><% out.print(dao.nomeUsuario(id_usuario)); %></h1>

                    <%
                        if (request.getSession().getAttribute("usuario") != null) {

                            usuario verificar = (usuario) session.getAttribute("usuario");
                            long ID = verificar.getID();

                            if (ID != Long.parseLong(id_usuario)) {

                                if (dao.seguindo(Long.toString(ID), id_usuario)) {
                    %>

                    Seguindo

                    <%                                } else {
                    %>

                    <form method="post" action="seguir">
                        <input type="hidden" value="${usuario.ID}" name="id_in"/>
                        <input type="hidden" value="<% out.print(id_usuario); %>" name="id_out"/>
                        <button type="submit" class="btn btn-default">Seguir</button>
                    </form>

                    <%
                                }
                            }

                        }
                    %>
                </div>

                <div class="info-usuario">

                    <div class="box">
                        <h2>Postagens</h2>
                        <span class="dados"><% out.print(dao.contar(id_usuario, 1)); %></span>
                    </div>

                    <div class="box">
                        <h2>Seguidores</h2>
                        <span class="dados"><% out.print(dao.contar(id_usuario, 3)); %></span>
                    </div>

                    <div class="box">
                        <h2>Seguindo</h2>
                        <span class="dados"><% out.print(dao.contar(id_usuario, 2)); %></span>
                    </div>

                    <div class="box">
                        <h2>Visualizações</h2>
                        <span class="dados"><% out.print(dao.contar(id_usuario, 4)); %></span>
                    </div>

                </div>
            </div>

            <div class="col-md-8 posts">

                <div class="row box" >
                    <h2>Sobre Mim</h2>
                    <div class="divisao"></div>
                    <p>
                        <%  out.print(dao.descricaoUsuario(id_usuario)); %>
                    </p>
                </div>

                <%
                    if (request.getSession().getAttribute("usuario") != null) {

                        usuario verificar = (usuario) session.getAttribute("usuario");
                        long ID = verificar.getID();

                        if (ID == Long.parseLong(id_usuario)) {

                %>

                <div class="row box">

                    <form method="post" action="postar">

                        <input type="hidden" value="${usuario.ID}" name="id_usuario"/>

                        <textarea name="post" class="form-control" rows="3" maxlength="8000" placeholder="Escreva o que você está pensando..." required></textarea>

                        <button type="submit" class="btn btn-success">Postar</button>

                    </form>

                </div>

                <%                        }
                    }
                %>

                <div class="row box">

                    <h2>Postagens</h2>
                    <div class="divisao"></div>


                    <%
                        if (request.getSession().getAttribute("usuario") != null) {

                            usuario verificar = (usuario) session.getAttribute("usuario");
                            long ID = verificar.getID();

                            List<post> postagem;
                            if (ID != Long.parseLong(id_usuario)) {

                                postagem = dao.getPost(id_usuario);

                                int posts = 0;
                                for (post post : postagem) {
                    %>

                    <div class="col-xs-12 post">

                        <div class="topo-post">

                            <div class="img-topo"> <a href="usuario.jsp?id=<%=post.getUsuario()%>"><img src='<% out.print(dao.imgUsuario(Integer.toString(post.getUsuario())));%>' /></a> </div>
                            <a href="usuario.jsp?id=<%=post.getUsuario()%>"> <% out.print(dao.nomeUsuario(Integer.toString(post.getUsuario())));%> </a> <span> <%=post.getData()%> às <%=post.getHora()%>. </span>

                        </div>


                        <p> <%=post.getPost()%> </p>


                    </div> 

                    <%
                            posts++;

                        }

                        if (posts == 0) {
                            out.println("<p>Nenhuma postagem no momento.</p>");
                        }
                    } else {

                        postagem = dao.getPostTime(id_usuario);

                        int posts = 0;
                        for (post post : postagem) {
                    %>

                    <div class="col-xs-12 post">

                        <div class="topo-post">

                            <div class="img-topo"> <a href="usuario.jsp?id=<%=post.getUsuario()%>"><img src='<% out.print(dao.imgUsuario(Integer.toString(post.getUsuario())));%>' /></a> </div>
                            <a href="usuario.jsp?id=<%=post.getUsuario()%>"> <% out.print(dao.nomeUsuario(Integer.toString(post.getUsuario())));%> </a> <span> <%=post.getData()%> às <%=post.getHora()%>. </span>

                        </div>


                        <p> <%=post.getPost()%> </p>


                    </div> 

                    <%
                                    posts++;

                                }

                                if (posts == 0) {
                                    out.println("<p>Nenhuma postagem no momento.</p>");
                                }
                            }
                        } else {
                            out.println("<p style='text-align:center; margin 10% 0 10% 0'>Para visualizar as postagens é possuir uma <a href='index.jsp'>conta</a>.</p>");
                        }
                    %>
                </div>

            </div>

            <div class="col-md-2 seguindo seguidor">

                <h2>Seguindo</h2>

                <ul class="row">
                    <%
                        int so = 0;
                        List<usuario> seguido = dao.getSeguido(id_usuario);
                        for (usuario usuario : seguido) {
                    %>
                    <li class="col-xs-4 seguidor">
                        <a href="usuario.jsp?id=<%=usuario.getID()%>">
                            <img class="img-responsive" src="<%out.print(dao.imgUsuario(Long.toString(usuario.getID())));%>" title="<%=usuario.getNome()%>">
                        </a>
                    </li> 
                    <%
                            so++;
                        }

                        if (so == 0) {
                            out.print("<p>Nenhum seguidor</p>");
                        }
                    %>
                </ul>   

                <h2>Seguido</h2>

                <ul class="row">
                    <%
                        List<usuario> seguindo = dao.getSeguindo(id_usuario);

                        int s = 0;
                        for (usuario usuario : seguindo) {
                    %>
                    <li class="col-xs-4">
                        <a href="usuario.jsp?id=<%=usuario.getID()%>">
                            <img class="img-responsive"  src="<%out.print(dao.imgUsuario(Long.toString(usuario.getID())));%>" title="<%=usuario.getNome()%>">
                        </a>
                    </li> 
                    <%
                            s++;
                        }

                        if (s == 0) {
                            out.print("<p>Nenhum seguidor</p>");
                        }
                    %>
                </ul>   

            </div>

        </div>

        <hr>

        <footer>

            <div class="top-footer">
                <p>Não encontrou o que procurava ?</p>
            </div>

            <div class="container">
                <div class="col-xs-4">
                    <h5>Páginas</h5>
                    <ul>
                        <li><a href="index.jsp">Página Inicial</a></li>
                        <li><a href="sobre.jsp">Saiba Mais</a></li>
                    </ul>
                </div>
                <div class="col-xs-4">
                    <h5>Política e Privacidade</h5>
                    <ul>
                        <li><a href="index.jsp">Termos de Uso</a></li>
                    </ul>
                </div>
                <div class="col-xs-4 central">
                    <img src="img/LogoOSocial-2.png" alt=""/>
                    <h4>Desenvolvido por:</h4>
                    <h1>Otávio Sanchez</h1>
                </div>
            </div>


            <div class="bottom-footer">
                <p>Copyright © 2015 oSocial. Todos os direitos reservados.</p>
            </div>
        </footer>

        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.js"></script>

        <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.11.2.js"><\/script>')</script>

        <script src="js/vendor/bootstrap.min.js"></script>

        <script src="js/main.js"></script>

    </body>
</html>
