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
            <p>Registrate</p>
        </h2>
        <form action=" " method="post">
            <div class="card" style="width: 50rem;">
                <div class="card-body">
                    <div class="row g-3">
                        <div class="col-md-4">
                            <label for="validationDefault01" class="form-label">Prénom</label>
                            <input type="text" class="form-control" id="validationDefault01" value=" " required>
                        </div>


                        <div class="col-md-4">
                            <label for="validationDefault02" class="form-label">Le nom</label>
                            <input type="text" class="form-control" id="validationDefault02" value=" " required>
                        </div>
                        <div class="col-md-4">
                            <label for="validationDefaultUsername" class="form-label">Utilisateur</label>
                            <div class="input-group">
                                <span class="input-group-text" id="inputGroupPrepend2">@</span>
                                <input type="text" class="form-control" id="validationDefaultUsername"
                                       aria-describedby="inputGroupPrepend2" required>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <label for="inputEmail" class="form-label">Poster</label>
                            <input type="email" class="form-control" id="inputEmail" placeholder="example@gmail.com"
                                   value=" " required>
                        </div>
                        <div class="col-md-6">
                            <label for="inputPassword" class="form-label">Mot de passe</label>
                            <input type="password" class="form-control" id="inputPassword" value="" required>
                        </div>
                        <div class="col-md-6">
                            <label for="inputdate" class="form-label">Date de naissance</label>
                            <input type="text" class="form-control" id="inputdate" values=" " required>
                        </div>
                        <div class="col-md-6">
                            <label for="inputCity" class="form-label">Ville</label>
                            <input type="text" class="form-control" id="inputCity" placeholder="México">
                        </div>

                        <div class="col-md-10">
                            <label for="inputAddress" class="form-label">Adresse</label>
                            <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St">
                        </div>
                        <div class="col-md-2">
                            <label for="inputZip" class="form-label">Code postal</label>
                            <input type="text" class="form-control" id="inputZip">
                        </div>

                        <div class="col-12">
                            <p>
                                <button type="submit" class="btn btn-primary">Crear cuenta</button>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>

    <footer style="background: blue">
        <p style="color: white">Derechos Reservados &copy; Eli´sBulk</p>

    </footer>
</center>
</body>
</html>