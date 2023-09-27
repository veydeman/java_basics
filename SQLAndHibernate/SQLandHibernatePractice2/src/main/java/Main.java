import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        String format = "%-" + 30 + "s";
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT students.id, courses.id FROM " + PurchaseList.class.getSimpleName() +
                " as purchaselist INNER JOIN " + Students.class.getSimpleName() + " as students " +
                " ON purchaselist.studentName " +
                " = students.name " +
                " INNER JOIN " + Courses.class.getSimpleName() + " as courses " +
                " ON courses.name = purchaselist.courseName";
        List<Object[]> list = session.createQuery(hql).getResultList();
        for (Object[] o : list) {
            LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList();
            linkedPurchaseList.setId(new LinkedPurchaseListKey((int) o[0], (int) o[1]));
            session.persist(linkedPurchaseList);
        }
        transaction.commit();
    }
}
