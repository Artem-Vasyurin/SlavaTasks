package vasyurin.apiclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import vasyurin.TimeDto;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClientImpl implements ApiClient {
    private final static URI URI = java.net.URI.create("http://worldclockapi.com/api/json/est/now");
    private final HttpClient client = HttpClient.newHttpClient();
    private final HttpRequest request = HttpRequest.newBuilder().GET().uri(URI).build();

    public TimeDto getTimeDto() {
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new ObjectMapper().readValue(response.body(), TimeDto.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
