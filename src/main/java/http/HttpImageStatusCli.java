package http;

import validators.InputValidator;

import java.util.Scanner;

public class HttpImageStatusCli {
    private HttpStatusImageDownloader httpStatusImageDownloader;

    public HttpImageStatusCli(){
        httpStatusImageDownloader = new HttpStatusImageDownloader();
    }
    public void askStatus(){
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter HTTP status code: ");
            String statusCodeString = scanner.nextLine();

            int statusCode = InputValidator.validateStatusCode(statusCodeString);

            if(statusCode == -1) continue;

            try {
                httpStatusImageDownloader.downloadStatusImage(statusCode);
                break;
            } catch (Exception ex) {
                System.out.println("There is not image for HTTP status: " + statusCode);
            }
        }
    }
}
