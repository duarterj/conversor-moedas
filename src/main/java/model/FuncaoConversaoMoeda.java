package model;

import service.ServiceCotacaoApi;

import javax.swing.*;

public class FuncaoConversaoMoeda {

        public void convertBrlUsd(double valor) throws Exception {
            double valorMoeda = convertBrlToCoin(valor, "USD");
            JOptionPane.showMessageDialog(null, "Você tem $ " + valorMoeda + " dólares");
        }

        public void convertBrlEur(double valor) throws Exception {
            double valorMoeda = convertBrlToCoin(valor, "EUR");
            JOptionPane.showMessageDialog(null, "Você tem € " + valorMoeda + " euros");
        }

        public void convertBrlGbp(double valor) throws Exception {
            double valorMoeda = convertBrlToCoin(valor, "GBP");
            JOptionPane.showMessageDialog(null, "Você tem £ " + valorMoeda + " libras esterlinas");
        }

        public void convertBrlArs(double valor) throws Exception {
            double valorMoeda = convertBrlToCoin(valor, "ARS");
            JOptionPane.showMessageDialog(null, "Você tem $ " + valorMoeda + " pesos argentinos");
        }

        public void convertBrlClp(double valor) throws Exception {
            double valorMoeda = convertBrlToCoin(valor, "CLP");
            JOptionPane.showMessageDialog(null, "Você tem $ " + valorMoeda + " pesos chilenos");
        }

        public void convertUsdBrl(double valor) throws Exception {
            double valorMoeda = convertCoinToBrl(valor, "USD");
            JOptionPane.showMessageDialog(null, "Você tem R$ " + valorMoeda + " reais");
        }

        public void convertEurBrl(double valor) throws Exception {
            double valorMoeda = convertCoinToBrl(valor, "EUR");
            JOptionPane.showMessageDialog(null, "Você tem R$ " + valorMoeda + " reais");
        }

        public void convertGbpBrl(double valor) throws Exception {
            double valorMoeda = convertCoinToBrl(valor, "GBP");
            JOptionPane.showMessageDialog(null, "Você tem R$ " + valorMoeda + " reais");
        }

        public void convertArsBrl(double valor) throws Exception {
            double valorMoeda = convertCoinToBrl(valor, "ARS");
            JOptionPane.showMessageDialog(null, "Você tem R$ " + valorMoeda + " reais");
        }

        public void convertClpBrl(double valor) throws Exception {
            double valorMoeda = convertCoinToBrl(valor, "CLP");
            JOptionPane.showMessageDialog(null, "Você tem R$ " + valorMoeda + " reais");
        }

        public double convertCoinToBrl(double valor, String moeda) throws Exception {
            Coin coin = ServiceCotacaoApi.buscaCotacaoPelo(moeda);
            double cotacao = coin.getConversion_rates().getBRL();
            double valorMoeda = valor * cotacao;
            return (double) Math.round(valorMoeda * 100d) / 100;
        }

        public double convertBrlToCoin(double valor, String moeda) throws Exception {
            Coin coin = ServiceCotacaoApi.buscaCotacaoPelo(moeda);
            double cotacao = coin.getConversion_rates().getBRL();
            double valorMoeda = valor / cotacao;
            return (double) Math.round(valorMoeda * 100d) / 100;
        }
}
