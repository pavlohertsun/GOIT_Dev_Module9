package http;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HttpStatusCheckerTest {

    @Test
    void getStatusImage200Test() throws Exception{
        HttpStatusChecker httpStatusChecker = new HttpStatusChecker();

        String expectedResult = "https://http.cat/200.jpg";
        String actualResult = httpStatusChecker.getStatusImage(200);

        Assertions.assertEquals(expectedResult, actualResult);
    }
    @Test
    void getStatusImage404Test() throws Exception{
        HttpStatusChecker httpStatusChecker = new HttpStatusChecker();

        String expectedResult = "https://http.cat/404.jpg";
        String actualResult = httpStatusChecker.getStatusImage(404);

        Assertions.assertEquals(expectedResult, actualResult);
    }
    @Test
    void getStatusImage99Test(){
        HttpStatusChecker httpStatusChecker = new HttpStatusChecker();

        assertThrows(Exception.class, () -> httpStatusChecker.getStatusImage(99));
    }
    @Test
    void getStatusImage1000Test(){
        HttpStatusChecker httpStatusChecker = new HttpStatusChecker();

        assertThrows(Exception.class, () -> httpStatusChecker.getStatusImage(1000));
    }

}