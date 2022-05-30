package servlet;

/**
 * Servlet implementation class Reloj
 * autor: Ricardo Vaca
 * variables:
 * metodos:
 *
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

@WebServlet(name = "Reloj", value = "/reloj")
public class Reloj extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Objeto calendario
        Calendar calendar = GregorianCalendar.getInstance(); // variable con la fecha de hoy
        // Obtener los parametros desde la web o URL
        String formato = request.getParameter("formato");
        String hora;

        if("12".equals(formato)){
            // Formato del reloj 12h
            hora = String.format("%s: %s: %s %s",
                    calendar.get(Calendar.HOUR_OF_DAY),
                    calendar.get(Calendar.MINUTE),
                    calendar.get(Calendar.SECOND),
                    calendar.get(Calendar.AM_PM) == 0 ? "am" : "pm"
            );
        } else {
            hora = String.format("%s: %s: %s",
                    calendar.get(Calendar.HOUR_OF_DAY),
                    calendar.get(Calendar.MINUTE),
                    calendar.get(Calendar.SECOND)
            );
        }
        // Imprimir la codificacion en la pantalla
        PrintWriter out = response.getWriter(); // Imprimir en la vista la informacion

        out.print(hora); // Imprimir en la vista la hora
        out.flush(); // Forzar la salida
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
