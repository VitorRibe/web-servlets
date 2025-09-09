/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.vitorribe.joaobotelhoexercicioservlets.negocio;

/**
 *
 * @author vitor
 */
public class Calculadora {
    public static String calcular(double num1, double num2) {
        StringBuilder sb = new StringBuilder();
        sb.append("<h2>Resultados:</h2><br>");
        sb.append("<p>").append(num1).append(" + ").append(num2).append(" = ").append(num1 + num2).append("</p>");
        sb.append("<p>").append(num1).append(" - ").append(num2).append(" = ").append(num1 - num2).append("</p>");
        sb.append("<p>").append(num1).append(" * ").append(num2).append(" = ").append(num1 * num2).append("</p>");
        if (num2 != 0) {
            sb.append("<p>").append(num1).append(" / ").append(num2).append(" = ").append(num1 / num2).append("</p>");
        } else {
            sb.append("<p>Divisão por zero não é permitida.</p>");
        }
        return sb.toString();
    }
}
