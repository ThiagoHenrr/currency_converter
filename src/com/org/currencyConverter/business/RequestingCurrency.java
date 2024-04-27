package com.org.currencyConverter.business;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.URI;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;


import java.io.IOException;
import java.lang.InterruptedException;

public class RequestingCurrency {

    public static String request(String base_currency, String target_currency)
            throws IOException, InterruptedException{

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/ed3301dff851213d7de5503f/pair/"
                        + base_currency + "/" + target_currency))
                .build();

        HttpResponse<String> response = client
                .send(request, BodyHandlers.ofString());

        return response.body();
    }
}
