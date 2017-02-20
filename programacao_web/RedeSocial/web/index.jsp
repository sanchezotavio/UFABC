	
<%@page import="java.util.List"%>
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->

    <%@ page import="com.dao.usuarioDAO" %>
    <%@ page import="com.conta.usuario" %>

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>oSocial</title>
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
            <div class="row">
                <div class="col-md-8 top-usuarios">

                    <article>
                        <h1>Sobre o <span>oSocial</span></h1>
                        <p>O oSocial é uma rede social destinada a pessoas que querem fazer novos amigos e fortalecer ainda mais os laços de amizades atuais. </p> 
                    </article>

                    <h2>Mais populares</h2>
                    <ul>
                        <%
                            usuarioDAO dao = new usuarioDAO();
                            List<usuario> usuarios = dao.getListaTop();
                            for (usuario usuario : usuarios) {
                        %>
                        <li class="col-xs-2 tops">
                            <a href="usuario.jsp?id=<%=usuario.getID()%>">
                                <img class="img-responsive" src="<%out.print(dao.imgUsuario(Long.toString(usuario.getID())));%>" title="<%=usuario.getNome()%>">
                            </a>
                        </li> 
                        <%
                            }
                        %>
                    </ul> 


                </div>

                <div class="col-md-4">
                    <h2>Criar nova conta</h2>
                    <form action="insere" method="post"  class="tu">
                        <div class="form-group">
                            <input type="text" placeholder="Digite o seu Nome" name="nome" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <input type="text" placeholder="Digite o seu Email" name="email" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <input type="password" placeholder="Digite uma Senha" name="senha" class="form-control" required>
                        </div>  
                        <div class="form-group">
                            <input type="password" placeholder="Confirme a Senha" class="form-control" required>
                        </div>
                        <div class="checkbox">
                            <label><input type="checkbox"> Você aceita os <a href="index.jsp" required="true">termos de uso</a>?</label>
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-default" role="button">Criar nova conta</button>
                        </div>
                    </form>
                </div>
            </div> 
        </div>

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
