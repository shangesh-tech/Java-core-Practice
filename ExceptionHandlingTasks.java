import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Custom exception for voting eligibility
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class ExceptionHandlingTasks {

    // Task 1: Divide two numbers (handles ArithmeticException)
    public static void divideNumbers() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter first number: ");
            int a = scanner.nextInt();

            System.out.print("Enter second number: ");
            int b = scanner.nextInt();

            int result = a / b;
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero!");
        }
    }

    // Task 2: Voting age check using custom exception
    public static void checkVotingEligibility() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        try {
            if (age < 18) {
                throw new InvalidAgeException("Age must be 18 or above to vote.");
            }
            System.out.println("You are eligible to vote.");
        } catch (InvalidAgeException e) {
            System.out.println("Custom Exception: " + e.getMessage());
        }
    }

    // Task 3: try-catch-finally with user input
    public static void readUserInput() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter any number: ");
            int num = scanner.nextInt();
            System.out.println("You entered: " + num);
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a number.");
        } finally {
            System.out.println("Finished reading input. (finally block)");
        }
    }

    // Task 4: File reading using throws
    public static void readFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner reader = new Scanner(file);
        System.out.println("File content:");
        while (reader.hasNextLine()) {
            System.out.println(reader.nextLine());
        }
        reader.close();
    }

    // Main method to run all tasks
    public static void main(String[] args) {
        System.out.println("\n--- Task 1: Divide Numbers ---");
        divideNumbers();

        System.out.println("\n--- Task 2: Voting Eligibility ---");
        checkVotingEligibility();

        System.out.println("\n--- Task 3: Try-Catch-Finally Input ---");
        readUserInput();

        System.out.println("\n--- Task 4: Read File with Throws ---");
        try {
            readFile("test.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
