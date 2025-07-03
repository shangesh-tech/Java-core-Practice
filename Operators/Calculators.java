import java.util.Scanner;

public class Calculators {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Get first number
        System.out.print("Enter first number: ");
        double num1 = scan.nextDouble();

        // Get operator
        System.out.print("Enter operator (+, -, *, /, %): ");
        String operator = scan.next();

        // Get second number
        System.out.print("Enter second number: ");
        double num2 = scan.nextDouble();

        // Calculate and show result
        double result = 0;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            case "%":
                result = num1 % num2;
                break;
            default:
                System.out.println("Invalid operator!");
                scan.close();
                return;
        }

        System.out.println(num1 + " " + operator + " " + num2 + " = " + result);
        scan.close();
    }
}
