import java.io.*;

class UserProfile implements Serializable {
    private static final long serialVersionUID = 1L;

    String username;
    String email;
    int age;
    transient String password;

    UserProfile(String username, String email, int age, String password) {
        this.username = username;
        this.email = email;
        this.age = age;
        this.password = password;
    }

    void displayProfile() {
        System.out.println("Username : " + username);
        System.out.println("Email    : " + email);
        System.out.println("Age      : " + age);
        System.out.println("Password : " + password);
    }
}

public class UserProfileSerializationDemo {
    public static void main(String[] args) {
        UserProfile user = new UserProfile("john_doe", "john@example.com", 25, "secret123");

        try {
            FileOutputStream fileOut = new FileOutputStream("userprofile.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(user);
            out.close();
            fileOut.close();

            System.out.println("UserProfile object serialized to 'userprofile.ser'\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fileIn = new FileInputStream("userprofile.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            UserProfile deserializedUser = (UserProfile) in.readObject();
            in.close();
            fileIn.close();

            System.out.println("Deserialized UserProfile object:");
            deserializedUser.displayProfile();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
