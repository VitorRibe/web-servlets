/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.vitorribe.joaobotelhoexercicioservlets.negocio;

/**
 *
 * @author vitor
 */
public class IMC {
     public static String calcular(double peso, double altura) {
        if (altura <= 0) return "Altura inválida!";
        double imc = peso / (altura * altura);
        String classificacao;

        if (imc < 18.5) classificacao = "Baixo peso";
        else if (imc < 25) classificacao = "Peso normal";
        else if (imc < 30) classificacao = "Sobrepeso";
        else classificacao = "Obesidade";

        return String.format("<p>IMC: %.2f - %s</p>", imc, classificacao);
    }
}
