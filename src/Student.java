import java.util.*;

public class Student {
    private String name;
    private String studentID;
    private static Scanner input = new Scanner(System.in);
    private List<Course> courses;

    public Student(String name, String studentID) {
        this.name = name;
        this.studentID = studentID;
        this.courses = new ArrayList<>();
    }

    public String getStudentName() { return name; }
    public String getStudentID() { return studentID; }

    @Override
    public String toString() {
        return "Student Name: " + getStudentName() + ", ID: " + getStudentID() + ", GPA: " + calculateGPA();
    }

    public void addCourse() {
        System.out.print("Enter course name: ");
        String cName = input.nextLine();
        System.out.print("Enter course code: ");
        String cCode = input.nextLine();
        System.out.print("Enter course grade: ");
        float cGrade = input.nextFloat();
        input.nextLine();

        Course course = new Course(cName, cCode, cGrade);
        courses.add(course);
        System.out.println("Course added: " + cName + " (" + cCode + ")");
    }

    public void removeCourse(String courseCode) {
        boolean flag = false;
        for (Course course : courses) {
            if (courseCode.equals(course.getCourseCode())) {
                courses.remove(course);
                flag = true;
                break;
            }
        }
        System.out.println((flag) ? "Course has been removed successfully." : "This course does not exist.");
    }

    public void printCourses() {
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    public float calculateGPA() {
        if (courses.isEmpty()) {
            return 0.0f;
        }
        float total = 0.0f;
        for (Course course : courses) {
            total += course.getCourseGrade();
        }
        return total / courses.size();
    }

    public Course findCoursebyCode(String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }
}
