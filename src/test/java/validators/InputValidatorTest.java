package validators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @Test
    void validateStatusCode404Test() {
        int expectedResult = 404;
        int actualResult = InputValidator.validateStatusCode("404");

        Assertions.assertEquals(expectedResult, actualResult);
    }
    @Test
    void validateStatusCodeTextTest() {
        int expectedResult = -1;
        int actualResult = InputValidator.validateStatusCode("text");

        Assertions.assertEquals(expectedResult, actualResult);
    }
}