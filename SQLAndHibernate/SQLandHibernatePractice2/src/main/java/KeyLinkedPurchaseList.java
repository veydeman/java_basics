import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class KeyLinkedPurchaseList implements Serializable {
    static final int serialVersionUTD = 1;

    @Column(name="student_id")
    private int studentId;

    @Column(name="course_id")
    private int courseId;

    public KeyLinkedPurchaseList() {
    }

    public KeyLinkedPurchaseList(int studentId, int courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }


}
