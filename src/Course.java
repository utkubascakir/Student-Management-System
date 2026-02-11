public class Course {
    private String courseName;
    private String courseCode;
    private float courseGrade;

    public Course(String courseName, String courseCode, float courseGrade) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.courseGrade = courseGrade;
    }

    @Override
    public String toString() {
        return "Course name: " + getCourseName() + " (" + getCourseCode() + "), score: " + getCourseGrade();
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public float getCourseGrade() {
        return courseGrade;
    }
}