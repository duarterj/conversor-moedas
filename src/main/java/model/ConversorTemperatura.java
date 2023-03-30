package model;

import javax.swing.*;

public class ConversorTemperatura implements Conversor {

    MetodosConversaoTemperatura temp = new MetodosConversaoTemperatura();

    @Override
    public void convert(double valor) throws Exception {
        String opcao = JOptionPane.showInputDialog(null,
                "Escolha a temperatura para qual deseja converter ", "Temperaturas",
                JOptionPane.PLAIN_MESSAGE, null,
                new Object[]{"De Celsius para Fahrenheit", "De Fahrenheit para Celsius", "De Celsius para Kelvin", "De Kelvin para Celsius",
                        "De Fahrenheit para Kelvin", "De Kelvin para Fahrenheit",},
                "Escolha").toString();

        switch (opcao) {
            case "De Celsius para Fahrenheit":
                temp.ConvertCelsiusToFahrenheit(valor);
                break;
            case "De Fahrenheit para Celsius":
                temp.ConvertFahrenheitToCelsius(valor);
                break;
            case "De Celsius para Kelvin":
                temp.ConvertCelsiusToKelvin(valor);
                break;
            case "De Kelvin para Celsius":
                temp.ConvertKelvinToCelsius(valor);
                break;
            case "De Fahrenheit para Kelvin":
                temp.ConvertFahrenheitTokelvin(valor);
                break;
            case "De Kelvin para Fahrenheit":
                temp.ConvertKelvinToFahrenheit(valor);
                break;
        }
    }
}
