package servlet;

/**
 * Servlet implementacion class Factura
 * Autor: Ricardo Vaca
 * Variables: nombre, apellido, subtotal, iva
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Factura", value = "/factura")
public class Factura extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        // Variables
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String subtotal = request.getParameter("subtotal");
        String iva = request.getParameter("iva");

        // Operaciones
        double doubleSubTotal = Double.parseDouble(subtotal);
        int intPorcentajeIva = Integer.parseInt(iva);
        double montoIva = (doubleSubTotal * intPorcentajeIva) /100;
        double total = doubleSubTotal + montoIva;
        // Terminamos las operaciones de la factura

        // Como ultimo paso se require mostrar la informacion
        // Imprimir desde el servlet = una pagina web

        StringBuilder sb = new StringBuilder();
        sb.append("<html>" +
                "<head>" +
                "<title>Resumen de la factura</title>" +
                "</head>" +
                "<body>" +
                "<h1>Factura</h1>" +
                "<p>" +
                "Cliente: " + nombre + " " + apellido +
                "</p>" +
                "<table>" +
                "<tr>" +
                "<td>Subtotal: " + doubleSubTotal + "</td>" +
                "</tr>" +
                "<tr>" +
                "<td>Monto iva: " + montoIva + "</td>" +
                "</tr>" +
                "<tr>" +
                "<td>Total: " + total + "</td>" +
                "</tr>" +
                "</table>" +
                "</body>" +
                "</html>");

        out.print(sb.toString());
        out.flush();
    }
}
