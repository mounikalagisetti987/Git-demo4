package com.calculator;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculate")
public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try {
            double num1 = Double.parseDouble(request.getParameter("num1"));
            double num2 = Double.parseDouble(request.getParameter("num2"));
            String operation = request.getParameter("operation");
            double result;

            switch (operation) {
                case "add":
                    result = num1 + num2;
                    break;
                case "sub":
                    result = num1 - num2;
                    break;
                case "mul":
                    result = num1 * num2;
                    break;
                case "div":
                    if (num2 == 0) {
                        response.sendError(HttpServletResponse.SC_BAD_REQUEST,
                                "Cannot divide by zero.");
                        return;
                    }
                    result = num1 / num2;
                    break;
                default:
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST,
                            "Unknown operation.");
                    return;
            }

            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html><html><head><title>Calculator Result</title></head><body>");
                out.println("<h2>Result: " + result + "</h2>");
                out.println("<p><a href=\"index.html\">Back to Calculator</a></p>");
                out.println("</body></html>");
            }
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST,
                    "Please enter valid numbers.");
        }
    }
}
