package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.api.response.QuotesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class QuotesService {

    @Value("${quotes.api.key}")
    private String apiKey;

    @Value("${quotes.api.url}")
    private String API;

    @Autowired
    private  RestTemplate restTemplate;

    public  List<QuotesResponse> getQuotes(){

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("X-Api-Key", apiKey);

        HttpEntity<?> httpEntity = new HttpEntity<>(httpHeaders);

        ResponseEntity<List<QuotesResponse>> response = restTemplate.exchange(API, HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<QuotesResponse>>() {});

        System.out.println(response.getBody());

        return response.getBody();
    }
}


