package vasyurin.TimeServideProject.apiclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import vasyurin.TimeServideProject.dto.TimeDto;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//@Service
public class ApiClientImpl implements ApiClient {
    private final HttpClient client;
    private final URI apiUri;


    public ApiClientImpl(@Value("${api.url}") String apiUrl) {
        this.client = HttpClient.newHttpClient();
        this.apiUri = URI.create(apiUrl);
    }

    public TimeDto getTimeDto() {
        HttpRequest request = HttpRequest.newBuilder().GET().uri(apiUri).build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return new ObjectMapper().readValue(response.body(), TimeDto.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
