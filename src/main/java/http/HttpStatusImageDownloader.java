package http;

import java.io.FileOutputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpStatusImageDownloader {
    private static final String BASE_FILE_PATH = "images/";
    private final HttpClient httpClient;
    public HttpStatusImageDownloader(){
        this.httpClient = HttpClient.newHttpClient();
    }

    public void downloadStatusImage(int code) throws Exception{
        HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
        String url = httpStatusChecker.getStatusImage(code);

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        HttpResponse<byte[]> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofByteArray());

        byte[] body = response.body();

        saveImage(body, createFilePath(url));
    }
    private void saveImage(byte[] body, String path){
        try(FileOutputStream fos = new FileOutputStream(path)){
            fos.write(body);
        } catch (Exception ex){
            System.out.println("Error while saving!");
        }
    }
    private String createFilePath(String url){
        String[] parts = url.split("/");
        return BASE_FILE_PATH + parts[parts.length - 1];
    }
}
