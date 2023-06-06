<%--
  Created by IntelliJ IDEA.
  User: Eli
  Date: 06/06/2023
  Time: 05:19 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="icon" href="../Imagen/logo pagina web.png">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Crear Cuenta</title>
</head>
<body>

<center>
    <div class="snippet-container mt-5">
        <h2>
            Registrate
        </h2>
        <form action="../SV" method="post">
            <div class="card" style="width: 50rem;">
                <div class="card-body">
                    <div class="row g-3">
                        <div class="col-md-4">
                            <label for="validationDefault01" class="form-label">Prénom</label>
                            <input type="text" class="form-control" id="validationDefault01" value="Mark" required>
                        </div>
                        <div class="col-md-4">
                            <label for="validationDefault02" class="form-label">Le nom</label>
                            <input type="text" class="form-control" id="validationDefault02" value="Otto" required>
                        </div>
                        <div class="col-md-4">
                            <label for="validationDefault01" class="form-label">Utilisateur</label>
                        </div>
                        <div class="col-md-6">
                            <label for="inputEmail4" class="form-label">Email</label>
                            <input type="email" class="form-control" id="inputEmail4">
                        </div>
                        <div class="col-md-6">
                            <label for="inputPassword4" class="form-label">Password</label>
                            <input type="password" class="form-control" id="inputPassword4">
                        </div>
                        <div class="col-12">
                            <label for="inputAddress" class="form-label">Direccion</label>
                            <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St">
                        </div>
                        <div class="col-12">
                            <label for="inputAddress2" class="form-label">Address 2</label>
                            <input type="text" class="form-control" id="inputAddress2"
                                   placeholder="Apartment, studio, or floor">
                        </div>
                        <div class="col-md-6">
                            <label for="inputCity" class="form-label">City</label>
                            <input type="text" class="form-control" id="inputCity">
                        </div>
                        <div class="col-md-4">
                            <label for="inputState" class="form-label">State</label>
                            <select id="inputState" class="form-select">
                                <option selected>Choose...</option>
                                <option>...</option>
                            </select>
                        </div>
                        <div class="col-md-2">
                            <label for="inputZip" class="form-label">Zip</label>
                            <input type="text" class="form-control" id="inputZip">
                        </div>
                        <div class="col-12">
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" id="gridCheck">
                                <label class="form-check-label" for="gridCheck">
                                    Check me out
                                </label>
                            </div>
                        </div>
                        <div class="col-12">
                            <button type="submit" class="btn btn-primary">Sign in</button>
                        </div>
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