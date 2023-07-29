import jakarta.persistence.criteria.CriteriaBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();



        KeyLinkedPurchaseList keyLinkedPurchaseList = new KeyLinkedPurchaseList(1,1);
        LinkedPurchaseList linkedPurchaseList = session.get(LinkedPurchaseList.class, keyLinkedPurchaseList);
        System.out.println(linkedPurchaseList.getId());
//        Teachers teacher = session.get(Teachers.class, 1);
//
//        String format = "%-" + 30 + "s";
//        System.out.printf(format, teacher.getId());
//        System.out.printf(format, teacher.getName());
//        System.out.printf(format, teacher.getSalary());
//        System.out.printf(format, teacher.getAge());
//
//        Courses course = session.get(Courses.class, 1);
//        System.out.printf(format, course.getName());
//        System.out.println(course.getDescription());
//        List<Students> students = course.getStudents();
//        students.forEach(student -> System.out.println(student.getName()));
//        System.out.println(course.getTeacher().getName());

    }
}
