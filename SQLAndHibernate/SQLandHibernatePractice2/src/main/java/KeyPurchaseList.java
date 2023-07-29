import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class KeyPurchaseList implements Serializable {
    static final int serialVersionUTD = 1;

    @Column(name="student_name", length = 5)
    private String studentName;

    @Column(name="course_name", length = 5)
    private String courseName;

}
