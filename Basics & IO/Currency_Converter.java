import java.util.Scanner;

public class Currency_Converter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // source currency
        System.out.print("Enter the source currency symbol (INR, USD, EUR): ");
        String fromCurrency = scan.next().toUpperCase();

        // target currency
        System.out.print("Enter the target currency symbol (INR, USD, EUR): ");
        String toCurrency = scan.next().toUpperCase();

        // amount
        System.out.print("Enter the amount to convert: ");
        double amount = scan.nextDouble();

        // 1 USD = 83 INR, 1 EUR = 90 INR, 1 USD = 0.92 EUR
        double convertedAmount = 0.0;
        boolean valid = true;

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
            System.out.printf("%.2f %s = %.2f %s", amount, fromCurrency, convertedAmount, toCurrency);

        } else {
            System.out.println("Invalid currency symbol entered.");
        }

        scan.close();
    }
}
