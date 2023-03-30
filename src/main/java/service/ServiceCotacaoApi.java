package service;

import com.google.gson.Gson;
import model.Coin;

import model.ConversorJsonString;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ServiceCotacaoApi {

    static String webService = "https://v6.exchangerate-api.com/v6/";
    static String token = "dd137d19236ebc036b897c70";
    static int codigoSucesso = 200;
    public static Coin buscaCotacaoPelo(String moeda) throws Exception {

        String urlParaChamada = webService + token + "/latest/" + moeda;

        try {
            URL url = new URL(urlParaChamada);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            if (conexao.getResponseCode() != codigoSucesso)
                throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());

            BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
            String jsonEmString = ConversorJsonString.converteJsonEmString(resposta);

            Gson gson = new Gson();
            Coin coin = gson.fromJson(jsonEmString, Coin.class);

            return coin;
        } catch (Exception e) {
            throw new Exception("ERROR: " + e);
        }
    }
}

