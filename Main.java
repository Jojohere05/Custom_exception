
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();
            try{
                switch (choice) {
                    case 1: addStudent(); break;
                    case 2: displayStudents(); break;
                    case 3: searchStudent(); break;
                    case 4: updateStudent(); break;
                    case 5: deleteStudent(); break;
                    case 6: System.exit(0);
                    default: System.out.println("Invalid option. Try again.");
                }  
            }catch (InvalidPRNException | NegativeMarksException e) {
                System.out.println("Error: " + e.getMessage());
            }

        }
    }
    public static void addStudent() throws InvalidPRNException, NegativeMarksException{
        System.out.print("Enter PRN: ");
        String prn = sc.nextLine();
        // Validate PRN format (assuming a simple validation rule for demonstration)
        if (!prn.matches("[A-Za-z0-9]+")) {
            throw new InvalidPRNException("Invalid PRN format.");
        }
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Date of Birth: ");
        String dob = sc.nextLine();
        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();
        if (marks < 0) {
            throw new NegativeMarksException("Marks cannot be negative.");
        }
        students.add(new Student(prn, name, dob, marks));
        System.out.println("Student added successfully.");

    }
    public static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
    public static void searchStudent() {
    }


}


