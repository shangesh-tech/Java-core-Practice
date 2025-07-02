import java.util.Scanner;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Advance_Currency {
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";

    public static double getExchangeRate(String fromCurrency, String toCurrency)
            throws IOException, InterruptedException {
        // Create the HTTP client
        HttpClient client = HttpClient.newHttpClient();

        // Create the request using the base currency
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL + fromCurrency))
                .build();

        // Send the request and get the response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Parse the JSON response
        JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();
        return json.getAsJsonObject("rates").get(toCurrency).getAsDouble();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        try {
            // source currency
            System.out.print("Enter the source currency symbol (INR, USD, EUR): ");
            String fromCurrency = scan.next().toUpperCase();

            // target currency
            System.out.print("Enter the target currency symbol (INR, USD, EUR): ");
            String toCurrency = scan.next().toUpperCase();

            // amount
            System.out.print("Enter the amount to convert: ");
            double amount = scan.nextDouble();

            try {
                // Get real-time exchange rate
                double rate = getExchangeRate(fromCurrency, toCurrency);
                double convertedAmount = amount * rate;

                // Display result with current exchange rate
                System.out.printf("%.2f %s = %.2f %s%n", amount, fromCurrency, convertedAmount, toCurrency);
                System.out.printf("Current exchange rate: 1 %s = %.4f %s%n", fromCurrency, rate, toCurrency);

            } catch (IOException | InterruptedException e) {
                System.out.println("Error fetching exchange rates: " + e.getMessage());
                System.out.println("Using fallback offline rates...");

                // Fallback to offline rates if API fails
                double convertedAmount = 0.0;
                boolean valid = true;

                // Offline conversion rates
                if (fromCurrency.equals("INR")) {
                    if (toCurrency.equals("USD")) {
                        convertedAmount = amount / 83.0;
                    } else if (toCurrency.equals("EUR")) {
                        convertedAmount = amount / 90.0;
                    } else if (toCurrency.equals("INR")) {
                        convertedAmount = amount;
                    } else {
                        valid = false;
                    }
                } else if (fromCurrency.equals("USD")) {
                    if (toCurrency.equals("INR")) {
                        convertedAmount = amount * 83.0;
                    } else if (toCurrency.equals("EUR")) {
                        convertedAmount = amount * 0.92;
                    } else if (toCurrency.equals("USD")) {
                        convertedAmount = amount;
                    } else {
                        valid = false;
                    }
                } else if (fromCurrency.equals("EUR")) {
                    if (toCurrency.equals("INR")) {
                        convertedAmount = amount * 90.0;
                    } else if (toCurrency.equals("USD")) {
                        convertedAmount = amount / 0.92;
                    } else if (toCurrency.equals("EUR")) {
                        convertedAmount = amount;
                    } else {
                        valid = false;
                    }
                } else {
                    valid = false;
                }

                if (valid) {
                    System.out.printf("%.2f %s = %.2f %s (using offline rates)%n",
                            amount, fromCurrency, convertedAmount, toCurrency);
                } else {
                    System.out.println("Invalid currency symbol entered.");
                }
            }
        } finally {
            scan.close();
        }
    }
}
