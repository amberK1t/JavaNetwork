package org.top.servletssandbox;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "cosinesServlet", value = "/cos")
public class CosinesServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        try {
            double a = Double.parseDouble(request.getParameter("a"));
            double b = Double.parseDouble(request.getParameter("b"));
            double corner = Double.parseDouble(request.getParameter("corner"));
            String type = request.getParameter("type");
            double c;

            if (type.contains("гр")) {
                c = Math.sqrt(a * a + b * b - 2 * a * b * Math.cos(Math.toRadians(corner)));
                out.println("Третья сторона = " + c);
            } else if (type.contains("рад")) {
                c = Math.sqrt(a * a + b * b - 2 * a * b * Math.cos(corner));
                out.println("Третья сторона = " + c);
            } else {
                out.println("Неверный тип угла");
            }
        } catch (Exception e) {
            out.println("Что-то пошло не так - " + e.getMessage());
        }
    }
}
