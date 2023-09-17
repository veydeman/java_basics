import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;

import java.io.Serializable;

@Embeddable
public class LinkedPurchaseListKey implements Serializable {
    static final int serialVersionUTD = 1;

    @Column(name="student_id")
    private int studentId;

    @Column(name="course_id")
    private int courseId;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public LinkedPurchaseListKey() {
    }

    public LinkedPurchaseListKey(int studentId, int courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }


}
