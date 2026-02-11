import java.util.*;
import java.io.IOException;

public class Main {

    private static Scanner scan = new Scanner(System.in);
    private static School school = new School("YTU", "Eyup Debik");

    public static void main(String[] args) {
        System.out.println("---Main Menu---");
        System.out.println("1-Add Student Profile");
        System.out.println("2-Search Student Profile");
        System.out.println("3-Print All Students");
        System.out.println("4-Exit");
        while (true) {
            System.out.print("\nEnter your choice: ");
            int mainChoice = scan.nextInt();
            scan.nextLine();
            System.out.println("\n");
            if (mainChoice == 4) {
                System.out.println("Exiting...");
                break;
            }
            if (mainChoice < 1 || mainChoice > 3) {
                System.out.println("Wrong choice, try again.");
            }

            switch (mainChoice) {
                case 1:
                    school.addStudent();
                    break;
                case 2:
                    studentProfile();
                    break;
                case 3:
                    school.printAllStudents();
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
        try {
            System.in.read();  // Bu, kullanıcının bir tuşa basmasını bekler
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void studentProfile() {
        System.out.print("Enter student ID: ");
        String tempID = scan.nextLine();
        school.printStudent(tempID);
        System.out.println("1-Add Course");
        System.out.println("2-Remove Course");
        System.out.println("3-Delete Student");
        System.out.print("\nSelect an operation: ");

        int profileChoice = scan.nextInt();
        switch (profileChoice) {
            case 1:
                school.addCourseToStudent(tempID);
                break;
            case 2:
                System.out.print("Enter course code: ");
                String tempCode = scan.nextLine();
                school.removeCourseFromStudent(tempID, tempCode);
                break;
            case 3:
                school.removeStudent(tempID);
                break;
            default:
                System.out.println("Invalid choice, please try again.");
        }
    }
}
