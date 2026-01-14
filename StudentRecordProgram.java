import java.util.*;
import java.util.regex.Pattern;

// Student class
class Student {
    int rollNo;
    String name;
    int age;

    Student(int rollNo, String name, int age) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "Roll No: " + rollNo + ", Name: " + name + ", Age: " + age;
    }
}

// Interface
interface StudentOperations {
    void addStudent(Student s);
    void displayStudents();
    void removeStudent(int rollNo);
    void searchStudent(int rollNo);
}

// Implementation class
class StudentManager implements StudentOperations {

    // Using List reference with ArrayList
    List<Student> studentList = new ArrayList<>();

    // Also demonstrating Vector
    Vector<Student> studentVector = new Vector<>();

    // REGEX for name validation
    boolean isValidName(String name) {
        return Pattern.matches("[A-Za-z ]+", name);
    }

    public void addStudent(Student s) {
        studentList.add(s);
        studentVector.add(s);
        System.out.println("Student added successfully");
    }

    public void displayStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No student records found");
            return;
        }
        for (Student s : studentList) {
            System.out.println(s);
        }
    }

    public void removeStudent(int rollNo) {
        Iterator<Student> it = studentList.iterator();
        boolean found = false;

        while (it.hasNext()) {
            Student s = it.next();
            if (s.rollNo == rollNo) {
                it.remove();
                studentVector.remove(s);
                found = true;
                System.out.println("Student removed successfully");
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found");
        }
    }

    public void searchStudent(int rollNo) {
        for (Student s : studentList) {
            if (s.rollNo == rollNo) {
                System.out.println("Student Found:");
                System.out.println(s);
                return;
            }
        }
        System.out.println("Student not found");
    }
}

// Main class
public class StudentRecordProgram {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        int choice;

        do {
            System.out.println("\n--- Student Record Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Remove Student by Roll No");
            System.out.println("4. Search Student by Roll No");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            try {
                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        System.out.print("Enter Roll No: ");
                        int roll = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        if (!manager.isValidName(name)) {
                            throw new IllegalArgumentException("Invalid name format");
                        }

                        System.out.print("Enter Age: ");
                        int age = sc.nextInt();

                        manager.addStudent(new Student(roll, name, age));
                        break;

                    case 2:
                        manager.displayStudents();
                        break;

                    case 3:
                        System.out.print("Enter Roll No to remove: ");
                        manager.removeStudent(sc.nextInt());
                        break;

                    case 4:
                        System.out.print("Enter Roll No to search: ");
                        manager.searchStudent(sc.nextInt());
                        break;

                    case 5:
                        System.out.println("Program exited");
                        break;

                    default:
                        System.out.println("Invalid choice");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input type");
                sc.nextLine();
                choice = 0;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 5);

        sc.close();
    }
}
