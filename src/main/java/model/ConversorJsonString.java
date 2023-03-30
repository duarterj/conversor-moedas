package model;

import java.io.BufferedReader;
import java.io.IOException;

public class ConversorJsonString {

    public static String converteJsonEmString(BufferedReader buffereReader) throws IOException {
        String resposta;
        String jsonEmString;
        for (jsonEmString = ""; (resposta = buffereReader.readLine()) != null; jsonEmString = jsonEmString + resposta) {
        }

        return jsonEmString;
    }
}
