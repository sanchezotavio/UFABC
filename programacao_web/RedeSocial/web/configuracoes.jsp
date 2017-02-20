<%@page import="java.util.List"%>
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->

    <%@ page import="com.dao.usuarioDAO" %>
    <%@ page import="com.conta.usuario" %>

    <head>

        <%

            if (request.getSession().getAttribute("usuario") == null) {
                String redirectURL = "index.jsp";
                response.sendRedirect(redirectURL);
            }
            
            usuarioDAO dao = new usuarioDAO();
            usuario verificar = (usuario) session.getAttribute("usuario");
            int id =(int)verificar.getID();
        %>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>

            oSocial | ${usuario.nome} | Configurações

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

            <div class="col-md-12 box">

                <h1>Minhas configurações</h1>

                <form action="alterar" method="post">
                    <input type="hidden" value="${usuario.ID}" name="id"/>
                    <div class="form-group">
                        <div>Nome</div>
                        <input type="text" name="nome" class="form-control" value="<% out.print(dao.nomeUsuario(Integer.toString(id)));%>" required/>
                    </div>
                    <div class="form-group">
                         <div>Descrição</div>
                         <textarea name="descricao" class="form-control" rows="3" maxlength="8000" required><% out.print(dao.descricaoUsuario(Integer.toString(id)));%></textarea>
                    </div>
                    <div class="form-group">
                         <div>Imagem do Perfil</div>
                         <input name="imagem" class="form-control" value="<% out.print(dao.imgUsuario(Integer.toString(id)));%>" required/>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-default" role="button">Alterar</button>
                    </div>
                </form>

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
