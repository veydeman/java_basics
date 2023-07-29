import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="LinkedPurchaseList")
public class LinkedPurchaseList {

    @EmbeddedId
    public KeyLinkedPurchaseList id;

    public KeyLinkedPurchaseList getId() {
        return id;
    }
}
