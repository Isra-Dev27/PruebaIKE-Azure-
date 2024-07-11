package com.function;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;

import java.util.Optional;
import org.json.JSONObject;

/**
 * Azure Functions with HTTP Trigger.
 */
public class PalindromeAnalyzer {
    @FunctionName("PalindromeChecker")
    public HttpResponseMessage run(
            @HttpTrigger(name = "req", methods = {
                    HttpMethod.POST }, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {
        context.getLogger().info("Java HTTP trigger processed a request.");

        // Retrieve the JSON body from the request
        String jsonBody = request.getBody().orElse(null);
        if (jsonBody == null) {
            return request.createResponseBuilder(HttpStatus.BAD_REQUEST)
                    .body("Please pass a JSON body with the parameter 'palindromo'").build();
        }

        // Parse the JSON body
        JSONObject jsonRequest = new JSONObject(jsonBody);
        if (!jsonRequest.has("palindromo")) {
            return request.createResponseBuilder(HttpStatus.BAD_REQUEST)
                    .body("JSON body must contain the parameter 'palindromo'").build();
        }

        // Extract the 'palindromo' parameter
        String palindromo = jsonRequest.getString("palindromo");

        // Calculate the length of the string
        int lengthCadena = palindromo.length();

        // Check if the string is a palindrome
        boolean isPalindrome = isPalindrome(palindromo);

        // Calculate the number of special characters in the string
        int lengthCaracteresEspeciales = getSpecialCharacterCount(palindromo);

        // Create the JSON response
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("lengthCadena", lengthCadena);
        jsonResponse.put("isPalindromo", isPalindrome ? 1 : 0);
        jsonResponse.put("lengthCaracteresEspeciales", lengthCaracteresEspeciales);

        // Return the response with status OK
        return request.createResponseBuilder(HttpStatus.OK).body(jsonResponse.toString()).build();
    }

    // Helper method to check if a string is a palindrome
    private boolean isPalindrome(String str) {
        String cleanedStr = str.replaceAll("[^a-zA-Z]", "").toLowerCase();
        String reversedStr = new StringBuilder(cleanedStr).reverse().toString();
        return cleanedStr.equals(reversedStr);
    }

    // Helper method to count the number of special characters in a string
    private int getSpecialCharacterCount(String str) {
        return (int) str.chars().filter(c -> !Character.isLetterOrDigit(c) && !Character.isWhitespace(c)).count();
    }
}
