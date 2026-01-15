import java.util.*;
import java.util.regex.Pattern;


class Student {
    int id;
    String name;
    String course;
    int marks;

    Student(int id, String name, String course, int marks) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name +
               ", Course: " + course + ", Marks: " + marks;
    }
}

interface UniversityOperations {
    void addStudent(Student s);
    void displayStudents();
    void removeStudent(int id);
    void searchStudent(int id);
    void sortByMarks();
    void convertHashMapToTreeMap();
    void countCourseWise();
    void displayCourses();
}

// Implementation class
class UniversityManager implements UniversityOperations {

    // List implementations
    List<Student> studentList = new ArrayList<>();
    Vector<Student> studentVector = new Vector<>();
    Stack<Student> studentStack = new Stack<>();

    // Set for unique courses
    Set<String> courseSet = new HashSet<>();

    // Map implementations
    HashMap<Integer, Student> studentMap = new HashMap<>();
    Hashtable<Integer, Student> studentTable = new Hashtable<>();
    TreeMap<Integer, Student> studentTreeMap = new TreeMap<>();

    // REGEX validations
    boolean validName(String name) {
        return Pattern.matches("[A-Za-z ]+", name);
    }

    boolean validCourse(String course) {
        return Pattern.matches("[A-Za-z ]+", course);
    }


    public void addStudent(Student s) {

        if (studentMap.containsKey(s.id)) {
            System.out.println("Duplicate student ID not allowed");
            return;
        }

        studentList.add(s);
        studentVector.add(s);
        studentStack.push(s);

        studentMap.put(s.id, s);
        studentTable.put(s.id, s);

        courseSet.add(s.course);

        System.out.println("Student added successfully");
    }

    public void displayStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students found");
            return;
        }
        for (Student s : studentList) {
            System.out.println(s);
        }
    }


    public void removeStudent(int id) {
        Student s = studentMap.remove(id);
        if (s != null) {
            studentTable.remove(id);
            studentList.remove(s);
            studentVector.remove(s);
            studentStack.remove(s);
            System.out.println("Student removed successfully");
        } else {
            System.out.println("Student not found");
        }
    }

    public void searchStudent(int id) {
        Student s = studentMap.get(id);
        if (s != null) {
            System.out.println("Student Found:");
            System.out.println(s);
        } else {
            System.out.println("Student not found");
        }
    }

    public void sortByMarks() {
        studentList.sort((a, b) -> b.marks - a.marks);
        System.out.println("Students sorted by marks");
        displayStudents();
    }

    public void convertHashMapToTreeMap() {
        studentTreeMap = new TreeMap<>(studentMap);
        System.out.println("HashMap converted to TreeMap");
        for (Student s : studentTreeMap.values()) {
            System.out.println(s);
        }
    }


    public void countCourseWise() {
        Map<String, Integer> countMap = new HashMap<>();

        for (Student s : studentList) {
            countMap.put(s.course, countMap.getOrDefault(s.course, 0) + 1);
        }

        System.out.println("Course-wise Student Count:");
        for (String course : countMap.keySet()) {
            System.out.println(course + " : " + countMap.get(course));
        }
    }

    public void displayCourses() {
        System.out.println("Available Courses:");
        for (String c : courseSet) {
            System.out.println(c);
        }
    }
}

public class UniversityStudentManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UniversityManager manager = new UniversityManager();
        int choice;

        do {
            System.out.println("\n--- University Student Management Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Remove Student by ID");
            System.out.println("4. Search Student by ID");
            System.out.println("5. Sort Students by Marks");
            System.out.println("6. Convert HashMap to TreeMap");
            System.out.println("7. Count Students Course-wise");
            System.out.println("8. Display All Courses");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");

            try {
                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Course: ");
                        String course = sc.nextLine();

                        if (!manager.validName(name) || !manager.validCourse(course)) {
                            throw new IllegalArgumentException("Invalid name or course");
                        }

                        System.out.print("Enter Marks: ");
                        int marks = sc.nextInt();

                        manager.addStudent(new Student(id, name, course, marks));
                        break;

                    case 2:
                        manager.displayStudents();
                        break;

                    case 3:
                        System.out.print("Enter ID to remove: ");
                        manager.removeStudent(sc.nextInt());
                        break;

                    case 4:
                        System.out.print("Enter ID to search: ");
                        manager.searchStudent(sc.nextInt());
                        break;

                    case 5:
                        manager.sortByMarks();
                        break;

                    case 6:
                        manager.convertHashMapToTreeMap();
                        break;

                    case 7:
                        manager.countCourseWise();
                        break;

                    case 8:
                        manager.displayCourses();
                        break;

                    case 9:
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

        } while (choice != 9);

        sc.close();
    }
}
