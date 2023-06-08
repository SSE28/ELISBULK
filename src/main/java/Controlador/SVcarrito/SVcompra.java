package Controlador.SVcarrito;
import Data.carritoDAO;
import Modelo.carritoJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SVcompra", value = "/SVcompra")
public class SVcompra extends HttpServlet {

    carritoJB carritoJB =new carritoJB();

    carritoDAO carritoDAO = new carritoDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("entra al ");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}