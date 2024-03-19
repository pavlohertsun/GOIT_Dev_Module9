package http;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class HttpStatusImageDownloaderTest {

    @Test
    void downloadStatusImage1000Test(){
        HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();

        assertThrows(Exception.class, () -> httpStatusImageDownloader.downloadStatusImage(1000));
    }
    @Test
    void downloadStatusImage200Test(){
        HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();

        assertDoesNotThrow(() -> httpStatusImageDownloader.downloadStatusImage(200));
    }
    @Test
    void downloadStatusImage404Test() throws Exception{
        HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();

        httpStatusImageDownloader.downloadStatusImage(404);

        File file = new File("images/404.jpg");
        assertTrue(file.exists());
    }
}