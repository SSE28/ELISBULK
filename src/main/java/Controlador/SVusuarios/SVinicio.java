package Controlador.SVusuarios;
import Data.usuariosDAO;
import Modelo.usuariosJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SVinicio", value = "/SVinicio")
public class SVinicio extends HttpServlet {

    usuariosJB usuariosJB =new usuariosJB();

    usuariosDAO usuariosDAO = new usuariosDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("entra al ");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
