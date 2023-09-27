import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PurchaseListKey implements Serializable {

    @Column(name="student_name")
    private String studentName;

    @Column(name="course_name")
    private String courseName;

    public PurchaseListKey(String studentName, String courseName) {
        this.studentName = studentName;
        this.courseName = courseName;
    }

    public PurchaseListKey() {
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "PurchaseListKey{" +
                "studentId=" + studentName +
                ", courseId=" + courseName +
                '}';
    }
}
