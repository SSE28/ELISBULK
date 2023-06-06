<%--
  Created by IntelliJ IDEA.
  User: Eduardo
  Date: 06/06/2023
  Time: 04:06 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="icon" href="../Imagen/logo pagina web.png">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Inicio Sesion</title>
</head>
<body>


<center>
    <div class="snippet-container mt-5">
        <h2>
            Inicio de sesion
        </h2>
        <form action="../SVinicio" method="post">
            <div class="card" style="width: 50rem;">
                <div class="card-body">
                    <div class="mb-3 row">
                        <label for="inputEmail" class="col-sm-2 col-form-label">Email</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputEmail">
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="inputPassword">
                        </div>
                    </div>
                    <div>
                    <p>
                        <button type="submit" class="btn btn-primary">Inicia sesión</button>
                    </p>
                    </div>

                        <a href="crear_cuenta.jsp">
                            Vous n'avez pas de compte ? Inscrivez-vous ici
                        </a>

                </div>
            </div>

        </form>
    </div>
    <footer style="background: black">
        <p style="color: white">Derechos Reservados &copy; Eli´sBulk</p>
    </footer>
</center>
</body>
</html>