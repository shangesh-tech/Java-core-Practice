public class Swap {
    // Method to swap numbers using a third variable
    public static void swapWithTemp(int a, int b) {
        System.out.println("Before swap (with temp): a = " + a + ", b = " + b);
        int temp = a;
        a = b;
        b = temp;
        System.out.println("After swap (with temp): a = " + a + ", b = " + b);
    }

    // Method to swap numbers without using a third variable
    public static void swapWithoutTemp(int a, int b) {
        System.out.println("Before swap (without temp): a = " + a + ", b = " + b);
        a = a + b; // a now contains sum of both numbers
        b = a - b; // b gets original value of a
        a = a - b; // a gets original value of b
        System.out.println("After swap (without temp): a = " + a + ", b = " + b);
    }

    public static void main(String[] args) {
        // Test swapping with temporary variable
        int num1 = 10;
        int num2 = 20;

        System.out.println("\nSwapping using temporary variable:");
        swapWithTemp(num1, num2);

        System.out.println("\nSwapping without temporary variable:");
        swapWithoutTemp(num1, num2);
    }
}
