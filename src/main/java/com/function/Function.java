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

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Azure Functions with HTTP Trigger.
 */
public class Function {
    @FunctionName("PersonFind")
    public HttpResponseMessage run(
            @HttpTrigger(name = "req", methods = { HttpMethod.GET,
                    HttpMethod.POST }, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {
        context.getLogger().info("Java HTTP trigger processed a request.");

        String myName = "TuNombre"; // Declare and initialize the variable with your name.

        // Complete the URL by sending the parameter name with the value of the declared
        // string.
        final String query = request.getQueryParameters().get("name");
        final String name = request.getBody().orElse(query != null ? query : myName);

        // Embedded JSON with the list of names and dates
        String jsonString = """
                {
                    "people": [
                        { "name": "Alice", "fecha": "Sun Feb 28 18:17:27 CST 2021" },
                        { "name": "Bob", "fecha": "Sun Feb 28 18:17:27 CST 2021" },
                        { "name": "Carlos", "fecha": "Sun Feb 28 18:17:27 CST 2021" },
                        { "name": "David", "fecha": "Sun Feb 28 18:17:27 CST 2021" },
                        { "name": "Eve", "fecha": "Sun Feb 28 18:17:27 CST 2021" }
                    ]
                }
                """;

        try {
            if (name == null) {
                return request.createResponseBuilder(HttpStatus.BAD_REQUEST)
                        .body("Please pass a name on the query string or in the request body").build();
            } else {
                // Parse the JSON string
                JSONObject jsonObject = new JSONObject(jsonString);
                JSONArray peopleArray = jsonObject.getJSONArray("people");

                boolean nameFound = false;
                JSONObject foundPerson = null;

                // Search for the name in the JSON array
                for (int i = 0; i < peopleArray.length(); i++) {
                    JSONObject person = peopleArray.getJSONObject(i);
                    if (person.getString("name").equalsIgnoreCase(name)) {
                        nameFound = true;
                        foundPerson = person;
                        break;
                    }
                }

                if (nameFound) {
                    // Create response JSON with the found person's details
                    JSONObject jsonResponse = new JSONObject();
                    jsonResponse.put("fecha", foundPerson.getString("fecha"));
                    jsonResponse.put("nombre", foundPerson.getString("name"));
                    return request.createResponseBuilder(HttpStatus.FOUND) // 302 Found
                            .body(jsonResponse.toString())
                            .build();
                } else {
                    return request.createResponseBuilder(HttpStatus.NOT_FOUND) // 404 Not Found
                            .body("Nombre no encontrado.")
                            .build();
                }
            }
        } catch (Exception e) {
            context.getLogger().severe("Exception: " + e.getMessage());
            return request.createResponseBuilder(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal server error: " + e.getMessage())
                    .build();
        }
    }
}
