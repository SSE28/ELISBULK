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
      <div class="card" style="width: 30rem;">
        <div class="card-body">
          <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Email</label>
            <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
          </div>
          <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label mt-2">Contraseña</label>
            <input type="password" name="contraseña" class="form-control mt-2" id="exampleInputPassword1">
          </div>
          <button type="submit" name="accion" value="ingresar" class="btn btn-primary mt-2">Submit</button>
          <div class="mt-3">
            <a href="registro.jsp">
              Vous n'avez pas de compte ? Inscrivez-vous ici
            </a>
          </div>
        </div>
      </div>
    </form>
  </div>
  <footer style="background: black">
    <p style="color: white">Derechos Reservados &copy;  Eli´sBulk</p>
  </footer>
</center>
</body>
</html>