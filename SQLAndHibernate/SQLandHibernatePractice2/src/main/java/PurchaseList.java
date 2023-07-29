import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "purchaselist")
public class PurchaseList {

    @Column(length = 5)
    @EmbeddedId
    private KeyPurchaseList id;

    private int price;

    @Column(name = "subscription_date")
    private Date date;

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
