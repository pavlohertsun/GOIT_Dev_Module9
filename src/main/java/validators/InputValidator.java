package validators;

public class InputValidator {
    public static int validateStatusCode(String statusCodeString){
        int statusCode = -1;
        try {
            statusCode = Integer.parseInt(statusCodeString);
            return statusCode;
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
        return statusCode;
    }
}
