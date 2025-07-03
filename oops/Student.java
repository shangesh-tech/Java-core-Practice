public class Student {
    // Fields
    private String name;
    private int age;
    private char grade;

    // Constructor
    public Student(String name, int age, char grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // Display method
    public void display() {
        System.out.println("Student Details:");
        System.out.println("Name : " + name);
        System.out.println("Age  : " + age);
        System.out.println("Grade: " + grade);
    }

    // Main method to test
    public static void main(String[] args) {
        Student student1 = new Student("Alice", 16, 'A');
        student1.display();
    }
}
