import java.util.*;
import java.util.regex.Pattern;


class Employee {
    int empId;
    String name;
    double salary;

    Employee(int empId, String name, double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return "ID: " + empId + ", Name: " + name + ", Salary: " + salary;
    }
}

interface EmployeeOperations {
    void addEmployee(Employee e);
    void displayEmployees();
    void searchEmployee(int empId);
    void removeEmployee(int empId);
}

// Implementation class
class EmployeeManager implements EmployeeOperations {

    HashMap<Integer, Employee> hashMap = new HashMap<>();

    Hashtable<Integer, Employee> hashTable = new Hashtable<>();

    TreeMap<Integer, Employee> treeMap = new TreeMap<>();

    // REGEX for name validation
    boolean isValidName(String name) {
        return Pattern.matches("[A-Za-z ]+", name);
    }

    // Add employee
    public void addEmployee(Employee e) {
        hashMap.put(e.empId, e);
        hashTable.put(e.empId, e);
        treeMap.put(e.empId, e);
        System.out.println("Employee added successfully");
    }

    // Display employees using HashMap
    public void displayEmployees() {
        if (hashMap.isEmpty()) {
            System.out.println("No employee records found");
            return;
        }
        for (Employee e : hashMap.values()) {
            System.out.println(e);
        }
    }

    // Search employee
    public void searchEmployee(int empId) {
        Employee e = hashMap.get(empId);
        if (e != null) {
            System.out.println("Employee Found:");
            System.out.println(e);
        } else {
            System.out.println("Employee not found");
        }
    }

    // Remove employee
    public void removeEmployee(int empId) {
        if (hashMap.remove(empId) != null) {
            hashTable.remove(empId);
            treeMap.remove(empId);
            System.out.println("Employee removed successfully");
        } else {
            System.out.println("Employee not found");
        }
    }

    // Demonstrate null support
    void showNullSupport() {
        System.out.println("\n--- Null Support Demo ---");

        hashMap.put(null, null);
        System.out.println("HashMap allows null key & value");

        try {
            hashTable.put(null, null);
        } catch (Exception e) {
            System.out.println("Hashtable does NOT allow null key/value");
        }

        // TreeMap does not allow null key
        try {
            treeMap.put(null, null);
        } catch (Exception e) {
            System.out.println("TreeMap does NOT allow null key");
        }
    }
}

public class EmployeeRecordProgram {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeManager manager = new EmployeeManager();
        int choice;

        do {
            System.out.println("\n--- Employee Record Menu ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Remove Employee by ID");
            System.out.println("5. Demonstrate Null Support");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            try {
                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        System.out.print("Enter Employee ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        if (!manager.isValidName(name)) {
                            throw new IllegalArgumentException("Invalid name format");
                        }

                        System.out.print("Enter Salary: ");
                        double salary = sc.nextDouble();

                        manager.addEmployee(new Employee(id, name, salary));
                        break;

                    case 2:
                        manager.displayEmployees();
                        break;

                    case 3:
                        System.out.print("Enter Employee ID to search: ");
                        manager.searchEmployee(sc.nextInt());
                        break;

                    case 4:
                        System.out.print("Enter Employee ID to remove: ");
                        manager.removeEmployee(sc.nextInt());
                        break;

                    case 5:
                        manager.showNullSupport();
                        break;

                    case 6:
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

        } while (choice != 6);

        sc.close();
    }
}
