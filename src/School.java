import java.util.*;

public class School {
    private String schoolName;
    private String principle;
    private static Scanner scan = new Scanner(System.in);
    private List<Student> students;

    public School(String schoolName, String principle) {
        this.schoolName = schoolName;
        this.principle = principle;
        this.students = new ArrayList<>();
    }

    public String getSchoolName() { return schoolName; }
    public String getPrinciple() { return principle; }

    public void addStudent() {
        System.out.print("Enter student name: ");
        String sName = scan.nextLine();
        System.out.print("Enter student ID: ");
        String sID = scan.nextLine();

        Student student = new Student(sName, sID);
        students.add(student);
        System.out.print("Student added: " + student.getStudentName() + " (" + student.getStudentID() + ")");
    }

    public void removeStudent(String studentID) {
        Student studentToRemove = findStudentbyID(studentID);
        if (studentToRemove != null) {
            students.remove(studentToRemove);
            System.out.println(studentToRemove.getStudentName() + " (" + studentToRemove.getStudentID() + ") is removed.");
        }
        else {
            System.out.println("This student does not exist.");
        }
    }

    public void printStudent(String studentID) {
        Student studentToPrint = findStudentbyID(studentID);
        if (studentToPrint != null) {
            System.out.println("Name: " + studentToPrint.getStudentName());
            System.out.println("ID: " + studentToPrint.getStudentID());
            System.out.println("Courses: ");
            studentToPrint.printCourses();
            System.out.println("GPA: " + studentToPrint.calculateGPA());
        }
        else {
            System.out.println("This student does not exist.");
        }
    }

    public void addCourseToStudent(String studentID) {
        Student addCourseStudent = findStudentbyID(studentID);
        if (addCourseStudent != null) {
            addCourseStudent.addCourse();
        }
        else {
            System.out.println("This student does not exist.");
        }
    }

    public void removeCourseFromStudent(String studentID, String courseCode) {
        Student removeCourseStudent = findStudentbyID(studentID);
        if (removeCourseStudent != null) {
            Course removeCourseCourse = removeCourseStudent.findCoursebyCode(courseCode);
            if (removeCourseCourse != null) {
                removeCourseStudent.removeCourse(courseCode);
            }
            else {
                System.out.println("Course not found.");
            }
        }
        else {
            System.out.println("Student not found.");
        }
    }

    public void printAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public Student findStudentbyID(String studentID) {
        for (Student student : students) {
            if (student.getStudentID().equals(studentID)) {
                return student;
            }
        }
        return null;
    }
}