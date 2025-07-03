import java.util.Scanner;

public class Interest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter principal amount: ");
        double principal = scan.nextDouble();

        System.out.print("Enter annual interest rate (%): ");
        double rate = scan.nextDouble();

        System.out.print("Enter time in years: ");
        int time = scan.nextInt();

        // Simple Interest calculation
        double SI = (principal * rate * time) / 100;

        // Compound Interest calculation
        double CI = principal * Math.pow((1 + rate / 100), time) - principal;

        // Display results rounded to 2 decimal places
        System.out.printf("Simple Interest: %.2f%n", SI);
        System.out.printf("Compound Interest: %.2f%n", CI);

        scan.close();
    }
}
