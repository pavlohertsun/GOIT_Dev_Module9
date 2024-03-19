package http;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpStatusChecker {
    private static final String BASE_URL = "https://http.cat/";
    private final HttpClient httpClient;
    public HttpStatusChecker(){
        this.httpClient = HttpClient.newHttpClient();
    }
    public String getStatusImage(int code) throws Exception{
        String url = BASE_URL + code + ".jpg";
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        int statusCode = response.statusCode();

        if(statusCode == 404) throw new Exception("Image not found");

        return url;
    }
}
