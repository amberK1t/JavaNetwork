package org.top.servletssandbox;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

 /* Задача: реализовать онлайн калькулятор КВУР вида ax^2 + bx + c = 0
  вход: a, b, c - коэффициенты уравнения (Double)
  результат: решение КВУР (нет корней; x1 = ...; x2 = ...; x = ...)

  Алгоритм:
      1) Посчитать дискриминант: D = b^2 - 4ac
      2) Если D < 0   -> корней нет
      3) Если D == 0  -> x = -b/2a
      4) Если D > 0   -> x1 = (-b - sqrt(D)) / 2a; x2 = (-b + sqrt(D)) / 2a

  Обратить внимание:
      a != 0
      a, b, c != null
*/

@WebServlet(name="qurServlet", value = "/qur")
public class qurServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        try {
            double a = Double.parseDouble(request.getParameter("a"));
            double b = Double.parseDouble(request.getParameter("b"));
            double c = Double.parseDouble(request.getParameter("c"));

            if (a == 0) {
                throw new IllegalArgumentException("параметр а не должен быть равен нулю");
            }

            double d = b * b - 4 * a * c;

            if (d < 0) {
                out.println("корней нет");
            }
            else if (d == 0) {
                double x = -b / (2 * a);
                out.println("один корень - " + x);
            }
            else if (d > 0) {
                double x1 = (-b - Math.sqrt(d)) / (2 * a);
                double x2 = (-b + Math.sqrt(d)) / (2 * a);
                out.println("два корня - " + x1 + " и " + x2);
            }
        } catch (Exception e) {
            out.println("exception - " + e.getMessage());
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Принят POST-запрос");
        String p = request.getParameter("p");
        System.out.println("Получен POST-параметр: " + p);
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

}
