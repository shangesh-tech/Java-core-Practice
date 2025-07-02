import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Weight
        System.out.print("Enter your weight in kilograms (kg): ");
        double weight = scan.nextDouble();
        scan.nextLine();

        // height
        System.out.print("Select Height in CM or Meter --> ");
        String select = scan.nextLine();
        double height;
        if (select.toUpperCase().equals("CM")) {
            System.out.print("Enter your height in Centimeter (cm): ");
            height = scan.nextDouble() * 0.01;
        } else {
            System.out.print("Enter your height in meters (m): ");
            height = scan.nextDouble();
        }

        // Calculate BMI
        double BMI = weight / (height * height);

        // Display BMI
        System.out.println("Your BMI is: " + BMI);

        // Determine and display BMI category
        if (BMI < 18.5) {
            System.out.println("You are underweight.");
        } else if (BMI >= 18.5 && BMI < 24.9) {
            System.out.println("You have a normal weight.");
        } else if (BMI >= 25 && BMI < 29.9) {
            System.out.println("You are overweight.");
        } else {
            System.out.println("You are obese.");
        }

        scan.close();

    }
}
