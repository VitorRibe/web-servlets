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
            out.println("<html><head>");
            out.println("<link rel='stylesheet' type='text/css' href='style.css'>");
            out.println("<title>Calculadora de IMC</title>");
            out.println("</head><body>");

            try {
                double peso = Double.parseDouble(pesoStr);
                double altura = Double.parseDouble(alturaStr);

                // Calcula IMC usando a classe de negócio
                IMC.ResultadoIMC resultado = IMC.calcular(peso, altura);
                double imc = resultado.valor;
                String faixa = resultado.faixa;

                // Define a cor da barra conforme a faixa
                String faixaClass;
                switch (faixa) {
                    case "Magreza": faixaClass = "imc-magreza"; break;
                    case "Normal": faixaClass = "imc-normal"; break;
                    case "Sobrepeso": faixaClass = "imc-sobrepeso"; break;
                    case "Obesidade": faixaClass = "imc-obesidade"; break;
                    default: faixaClass = "imc-magreza"; break;
                }

                // Converte IMC em percentual para a barra (escala 0-40)
                int widthPercent = (int) Math.min((imc / 40) * 100, 100);

                // Resultado 
                out.println("<h1>Seu IMC é: " + String.format("%.2f", imc) + "</h1>");
                out.println("<p>" + faixa + "</p>");

                // Barra visual
                out.println("<div class='imc-scale'>");
                out.println("<div class='imc-indicator " + faixaClass + "' style='width:" + widthPercent + "%'></div>");
                out.println("</div>");

                // Legenda
                out.println("<div class='imc-legend'>");
                out.println("<div><span>Magreza</span><br><small>&lt; 18.5</small></div>");
                out.println("<div><span>Normal</span><br><small>18.5 – 24.9</small></div>");
                out.println("<div><span>Sobrepeso</span><br><small>25 – 29.9</small></div>");
                out.println("<div><span>Obesidade</span><br><small>≥ 30</small></div>");
                out.println("</div>");

                // Botão
                out.println("<div class='center-container'>");
                out.println("<a class='btn-back' href='aplicacao3.html'>Voltar</a>");
                out.println("</div>");

            } catch (NumberFormatException e) {
                // Caso os valores não sejam números
                out.println("<p>Erro: valores inválidos! Insira apenas números.</p>");
                out.println("<div class='center-container'>");
                out.println("<a class='btn-back' href='aplicacao3.html'>Voltar</a>");
                out.println("</div>");
            }

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
