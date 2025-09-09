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
import io.github.vitorribe.joaobotelhoexercicioservlets.negocio.Ponto;


/**
 *
 * @author vitor
 */
@WebServlet(name = "DistanciaServlet", urlPatterns = {"/distancia"})
public class DistanciaServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("aplicacao2.html");
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

        String x1Str = request.getParameter("x1");
        String y1Str = request.getParameter("y1");
        String x2Str = request.getParameter("x2");
        String y2Str = request.getParameter("y2");

        try (PrintWriter out = response.getWriter()) {
            out.println("<html><link rel='stylesheet' type='text/css' href='style.css'><body>");
            out.println("<h1>Distância entre Pontos</h1>");

            try {
                double x1 = Double.parseDouble(x1Str);
                double y1 = Double.parseDouble(y1Str);
                double x2 = Double.parseDouble(x2Str);
                double y2 = Double.parseDouble(y2Str);

                Ponto p1 = new Ponto(x1, y1);
                Ponto p2 = new Ponto(x2, y2);
                double distancia = p1.distancia(p2);

                out.println("<p>Distância entre os pontos: " + distancia + "</p>");

            } catch (NumberFormatException e) {
                out.println("<p>Erro: valores inválidos! Insira apenas números.</p>");
            }

            out.println("<div class='center-container'>");
            out.println("<a class='btn-back' href='aplicacao2.html'>Voltar</a>");
            out.println("</div>");
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
        return "Servlet que calcula a distância entre dois pontos";
    }// </editor-fold>

}
