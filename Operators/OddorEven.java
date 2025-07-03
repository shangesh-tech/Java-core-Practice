import java.util.Scanner;

public class OddorEven {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the number : ");
        int number = scan.nextInt();

        System.out.println("Traditional way using % --- >");

        if (number % 2 == 0) {
            System.out.println("This is even number : " + number);
        } else {
            System.out.println("This is odd number : " + number);
        }

        System.out.println("using Ternary opertaor --- >");

        String result = (number % 2 == 0) ? "Even no" : "odd no";
        System.out.println(result);

        System.out.println("using Bitwise operator --- >");

        if ((number & 1) == 0) {
            System.out.println(number + " is Even");
        } else {
            System.out.println(number + " is Odd");
        }

        scan.close();
    }
}
