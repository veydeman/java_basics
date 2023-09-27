import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "purchaselist")
public class PurchaseList {

    @EmbeddedId
    private PurchaseListKey id;

    @Column(name = "course_name", insertable = false, updatable = false)
    private String courseName;

    @Column(name = "student_name", insertable = false, updatable = false)
    private String studentName;

    private int price;

    @Column(name = "subscription_date")
    private Date date;

    public PurchaseListKey getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setId(PurchaseListKey id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
