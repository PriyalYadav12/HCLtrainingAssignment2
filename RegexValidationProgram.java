import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexValidationProgram {

    // Validate Mobile Number (10 digits, starts with 6-9)
    static boolean checkMobile(String mobile) {
        return Pattern.matches("[6-9][0-9]{9}", mobile);
    }

    // Validate Email ID
    static boolean checkEmail(String email) {
        return Pattern.matches(
                "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}",
                email
        );
    }

    // Validate Username (letters, numbers, 5–15 chars)
    static boolean checkUsername(String name) {
        return Pattern.matches("[a-zA-Z0-9]{5,15}", name);
    }

    // Validate Password (min 8 chars, 1 digit, 1 special char)
    static boolean checkPassword(String pass) {
        return Pattern.matches(
                "(?=.*[0-9])(?=.*[@#$%^&+=]).{8,}",
                pass
        );
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- REGEX Validation Menu ---");
            System.out.println("1. Validate Mobile Number");
            System.out.println("2. Validate Email ID");
            System.out.println("3. Validate Username");
            System.out.println("4. Validate Password");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = sc.nextInt();
                sc.nextLine(); // clear buffer

                switch (choice) {

                    case 1:
                        System.out.print("Enter Mobile Number: ");
                        String mobile = sc.nextLine();
                        if (checkMobile(mobile))
                            System.out.println("Welcome! Valid Mobile Number");
                        else
                            System.out.println("Invalid Mobile Number");
                        break;

                    case 2:
                        System.out.print("Enter Email ID: ");
                        String email = sc.nextLine();
                        if (checkEmail(email))
                            System.out.println("Welcome! Valid Email ID");
                        else
                            System.out.println("Invalid Email ID");
                        break;

                    case 3:
                        System.out.print("Enter Username: ");
                        String user = sc.nextLine();
                        if (checkUsername(user))
                            System.out.println("Welcome! Valid Username");
                        else
                            System.out.println("Invalid Username");
                        break;

                    case 4:
                        System.out.print("Enter Password: ");
                        String pass = sc.nextLine();
                        if (checkPassword(pass))
                            System.out.println("Welcome! Strong Password");
                        else
                            System.out.println("Invalid Password");
                        break;

                    case 5:
                        System.out.println("Program Exited");
                        break;

                    default:
                        System.out.println("Invalid choice");
                }

            } catch (Exception e) {
                System.out.println("Error: Please enter valid input");
                sc.nextLine(); // clear invalid input
                choice = 0;
            }

        } while (choice != 5);

        sc.close();
    }
}
