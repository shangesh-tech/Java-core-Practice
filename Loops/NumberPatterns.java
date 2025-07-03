import java.util.Scanner;

public class NumberPatterns {

    // Floyd’s Triangle
    public static void floydsTriangle(int rows) {
        int number = 1;
        System.out.println("\nFloyd's Triangle:");
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(number + " ");
                number++;
            }
            System.out.println();
        }
    }

    // Number Pyramid
    public static void numberPyramid(int rows) {
        System.out.println("\nNumber Pyramid:");
        for (int i = 1; i <= rows; i++) {
            // Print spaces
            for (int s = 1; s <= rows - i; s++) {
                System.out.print(" ");
            }
            // Print numbers
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    // Diamond Number Pattern
    public static void diamondNumberPattern(int n) {
        System.out.println("\nDiamond Number Pattern:");
        // Upper half
        for (int i = 1; i <= n; i++) {
            for (int s = 1; s <= n - i; s++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        // Lower half
        for (int i = n - 1; i >= 1; i--) {
            for (int s = 1; s <= n - i; s++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Number Pattern Printer");
        System.out.print("Enter number of rows (e.g. 5): ");
        int rows = scan.nextInt();

        while (true) {
            System.out.println("\nChoose pattern to print:");
            System.out.println("1. Floyd's Triangle");
            System.out.println("2. Number Pyramid");
            System.out.println("3. Diamond Number Pattern");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    floydsTriangle(rows);
                    break;
                case 2:
                    numberPyramid(rows);
                    break;
                case 3:
                    diamondNumberPattern(rows);
                    break;
                case 4:
                    System.out.println("Exiting. Goodbye!");
                    scan.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
