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

/**
 *
 * @author vitor
 * 
 * Servlet da Aplicação 1: Calculadora GET
 * Recebe dois números via GET e retorna os resultados das operações básicas.
 */
@WebServlet(name = "CalculadoraServlet", urlPatterns = {"/calculadora"})
public class CalculadoraServlet extends HttpServlet {

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

        response.setContentType("text/html;charset=UTF-8");

        String num1Str = request.getParameter("num1");
        String num2Str = request.getParameter("num2");

        try (PrintWriter out = response.getWriter()) {
            out.println("<html><body>");
            out.println("<h1>Calculadora GET</h1>");

            try {
                double num1 = Double.parseDouble(num1Str);
                double num2 = Double.parseDouble(num2Str);

                // chamada da classe de negócio
                out.println(io.github.vitorribe.joaobotelhoexercicioservlets.negocio.Calculadora.calcular(num1, num2));

            } catch (NumberFormatException e) {
                out.println("<p>Erro: valores inválidos! Insira apenas números.</p>");
            }

            out.println("<a href='aplicacao1.html'>Voltar</a>");
            out.println("</body></html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet que processa a Calculadora GET";
    }// </editor-fold>

}
