package model;

import javax.swing.*;

public class MetodosConversaoTemperatura {

    public void ConvertCelsiusToFahrenheit(double valor){
        double fahrenheit = (valor * 1.8) + 32;
        JOptionPane.showMessageDialog(null, "Valor em Celsius " + valor + " em Fahrenheit " + fahrenheit);
    }
    public void ConvertFahrenheitToCelsius(double valor){
        double celsius = (valor - 32)/1.8;
        JOptionPane.showMessageDialog(null, "Valor em Fahrenheit " + valor + " em Celsius " + celsius);
    }
    public void ConvertCelsiusToKelvin(double valor){
        double kelvin = valor + 273.15;
        JOptionPane.showMessageDialog(null, "Valor em Celsius " + valor + " em Kelvin " + kelvin);
    }
    public void ConvertKelvinToCelsius(double valor){
        double celsius = valor - 273.15;
        JOptionPane.showMessageDialog(null, "Valor em Kelvin " + valor + " em Celsius " + celsius);
    }
    public void ConvertFahrenheitTokelvin(double valor){
        double kelvin = (valor - 32) * 5/9 + 273;
        JOptionPane.showMessageDialog(null, "Valor em Fahrenheit " + valor + " em Kelvin " + kelvin);
    }
    public void ConvertKelvinToFahrenheit(double valor){
        double fahrenheit = (valor - 273) * 1.8 + 32;
        JOptionPane.showMessageDialog(null, "Valor em Kelvin " + valor + " em Fahrenheit " + fahrenheit);
    }
}
