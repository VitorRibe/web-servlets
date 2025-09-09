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
     // Classe auxiliar para retornar tanto o valor quanto a faixa
    public static class ResultadoIMC {
        public double valor;
        public String faixa;

        public ResultadoIMC(double valor, String faixa) {
            this.valor = valor;
            this.faixa = faixa;
        }
    }

    // Método principal para calcular IMC e classificação
    public static ResultadoIMC calcular(double peso, double altura) {
        if (altura <= 0) return new ResultadoIMC(0, "Altura inválida!");

        double imc = peso / (altura * altura);
        String classificacao;

        if (imc < 18.5) {
            classificacao = "Magreza";
        } else if (imc < 25) {
            classificacao = "Normal";
        } else if (imc < 30) {
            classificacao = "Sobrepeso";
        } else {
            classificacao = "Obesidade";
        }

        return new ResultadoIMC(imc, classificacao);
    }
}
