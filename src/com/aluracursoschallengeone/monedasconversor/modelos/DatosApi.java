package com.aluracursoschallengeone.monedasconversor.modelos;


import com.aluracursoschallengeone.monedasconversor.service.ConvertirDatos;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DatosApi {

  public ConvertirDatos buscarDatos(String denominacionBase){

      URI  direccion =URI.create("https://v6.exchangerate-api.com/v6/4f4682a5d32a4779987528a8/latest/"+denominacionBase);
      HttpClient  client =HttpClient.newHttpClient();
      HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();

      try{
          HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
          return new Gson().fromJson(response.body(), ConvertirDatos.class);

         }catch (Exception e){
                throw new RuntimeException("Fallo la conversion");
         }
  }
}
