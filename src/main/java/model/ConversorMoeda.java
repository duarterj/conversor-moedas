package model;

import javax.swing.*;

public class ConversorMoeda implements Conversor {
    FuncaoConversaoMoeda moedas = new FuncaoConversaoMoeda();

    @Override
    public void convert(double valor) throws Exception{
        String opcao = JOptionPane.showInputDialog(null,
                "Escolha a moeda para a qual você deseja converter seu dinheiro ", "Moedas", JOptionPane.PLAIN_MESSAGE, null,
                new Object[]{"De Reais a Dólares", "De Reais a Euros", "De Reais a Libras", "De Reais a Pesos Argentinos",
                        "De Reais a Peso Chileno", "De Dólares a Reais", "De Euros a Reais", "De Libras a Reais", "De Pesos Argentinos a Reais",
                        "De Pesos Chilenos a Reais"},
                "Escolha"
        ).toString();

        switch (opcao) {
            case "De Reais a Dólares":
                moedas.convertBrlUsd(valor);
                break;
            case "De Reais a Euros":
                moedas.convertBrlEur(valor);
                break;
            case "De Reais a Libras":
                moedas.convertBrlGbp(valor);
                break;
            case "De Reais a Pesos Argentinos":
                moedas.convertBrlArs(valor);
                break;
            case "De Reais a Peso Chileno":
                moedas.convertBrlClp(valor);
                break;
            case "De Dólares a Reais":
                moedas.convertUsdBrl(valor);
                break;
            case "De Euros a Reais":
                moedas.convertEurBrl(valor);
                break;
            case "De Libras a Reais":
                moedas.convertGbpBrl(valor);
                break;
            case "De Pesos Argentinos a Reais":
                moedas.convertArsBrl(valor);
                break;
            case "De Pesos Chilenos a Reais":
                moedas.convertClpBrl(valor);
                break;
        }
    }
}

