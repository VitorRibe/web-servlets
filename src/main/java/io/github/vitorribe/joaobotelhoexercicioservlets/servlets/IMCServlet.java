/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package io.github.vitorribe.joaobotelhoexercicioservlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import io.github.vitorribe.joaobotelhoexercicioservlets.negocio.IMC;

/**
 *
 * @author vitor
 */
@WebServlet(name = "IMCServlet", urlPatterns = {"/imc"})
public class IMCServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("aplicacao3.html");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String pesoStr = request.getParameter("peso");
        String alturaStr = request.getParameter("altura");

        try (PrintWriter out = response.getWriter()) {
            out.println("<html><body>");
            out.println("<h1>Calculadora de IMC</h1>");

            try {
                double peso = Double.parseDouble(pesoStr);
                double altura = Double.parseDouble(alturaStr);

                out.println(IMC.calcular(peso, altura));

            } catch (NumberFormatException e) {
                out.println("<p>Erro: valores inválidos! Insira apenas números.</p>");
            }

            out.println("<a href='aplicacao3.html'>Voltar</a>");
            out.println("</body></html>");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet que calcula IMC";
    }// </editor-fold>

}
