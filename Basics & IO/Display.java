import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;

public class Display {
    // ANSI color codes for console formatting
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m";
    private static final String CYAN = "\u001B[36m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user information with validation
        String name = getValidName(scanner);
        int age = getValidAge(scanner);
        String gender = getValidGender(scanner);
        String hobbies = getHobbies(scanner);
        String email = getValidEmail(scanner);

        // Clear console (attempt to, works on some terminals)
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // Display profile card
        displayProfileCard(name, age, gender, hobbies, email);

        scanner.close();
    }

    private static String getValidName(Scanner scanner) {
        String name;
        do {
            System.out.print(BLUE + "Enter your name: " + RESET);
            name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println(RED + "Name cannot be empty!" + RESET);
            } else if (!name.matches("[a-zA-Z\\s]+")) {
                System.out.println(RED + "Name should contain only letters and spaces!" + RESET);
                name = "";
            }
        } while (name.isEmpty());
        return name;
    }

    private static int getValidAge(Scanner scanner) {
        int age = 0;
        boolean validAge = false;
        do {
            try {
                System.out.print(BLUE + "Enter your age: " + RESET);
                age = Integer.parseInt(scanner.nextLine().trim());
                if (age < 0 || age > 150) {
                    System.out.println(RED + "Please enter a valid age between 0 and 150!" + RESET);
                } else {
                    validAge = true;
                }
            } catch (NumberFormatException e) {
                System.out.println(RED + "Please enter a valid number!" + RESET);
            }
        } while (!validAge);
        return age;
    }

    private static String getValidGender(Scanner scanner) {
        String gender;
        do {
            System.out.print(BLUE + "Enter your gender (M/F/O): " + RESET);
            gender = scanner.nextLine().trim().toUpperCase();
            if (!gender.matches("[MFO]")) {
                System.out.println(RED + "Please enter M, F, or O (for Other)!" + RESET);
            }
        } while (!gender.matches("[MFO]"));
        return gender.equals("M") ? "Male" : gender.equals("F") ? "Female" : "Other";
    }

    private static String getHobbies(Scanner scanner) {
        System.out.print(BLUE + "Enter your hobbies (comma-separated): " + RESET);
        return scanner.nextLine().trim();
    }

    private static String getValidEmail(Scanner scanner) {
        String email;
        do {
            System.out.print(BLUE + "Enter your email: " + RESET);
            email = scanner.nextLine().trim();
            if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                System.out.println(RED + "Please enter a valid email address!" + RESET);
            }
        } while (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$"));
        return email;
    }

    private static void displayProfileCard(String name, int age, String gender, String hobbies, String email) {
        // Calculate birth year
        int birthYear = LocalDate.now().getYear() - age;

        // Create border
        String border = PURPLE + "+" + "=".repeat(50) + "+" + RESET;
        String emptyLine = PURPLE + "|" + " ".repeat(50) + "|" + RESET;

        // Display card
        System.out.println("\n" + border);
        System.out.println(emptyLine);
        System.out.printf(PURPLE + "| " + CYAN + "%-48s" + PURPLE + " |%n" + RESET, "🎭 PROFILE CARD");
        System.out.println(emptyLine);
        System.out.printf(PURPLE + "| " + GREEN + "Name    : %-41s" + PURPLE + " |%n" + RESET, name);
        System.out.printf(PURPLE + "| " + YELLOW + "Age     : %-41d" + PURPLE + " |%n" + RESET, age);
        System.out.printf(PURPLE + "| " + CYAN + "Gender  : %-41s" + PURPLE + " |%n" + RESET, gender);
        System.out.printf(PURPLE + "| " + GREEN + "Born in : %-41d" + PURPLE + " |%n" + RESET, birthYear);
        System.out.printf(PURPLE + "| " + YELLOW + "Email   : %-41s" + PURPLE + " |%n" + RESET, email);
        System.out.println(emptyLine);

        // Display hobbies with word wrap
        System.out.printf(PURPLE + "| " + CYAN + "Hobbies : %-41s" + PURPLE + " |%n" + RESET,
                hobbies.length() > 41 ? hobbies.substring(0, 38) + "..." : hobbies);

        if (hobbies.length() > 41) {
            String[] words = hobbies.split(",\\s*");
            StringBuilder line = new StringBuilder();
            for (String word : words) {
                if (line.length() + word.length() > 41) {
                    if (!line.isEmpty()) {
                        System.out.printf(PURPLE + "| " + CYAN + "%-48s" + PURPLE + " |%n" + RESET,
                                line.toString().trim());
                        line = new StringBuilder();
                    }
                }
                if (line.isEmpty()) {
                    line.append(word);
                } else {
                    line.append(", ").append(word);
                }
            }
            if (!line.isEmpty()) {
                System.out.printf(PURPLE + "| " + CYAN + "%-48s" + PURPLE + " |%n" + RESET, line.toString().trim());
            }
        }

        System.out.println(emptyLine);
        System.out.println(border);
    }
}
