import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.mapping.PrimaryKey;

import static org.hibernate.id.PersistentIdentifierGenerator.PK;


public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        SubscriptionsKey subscriptionsKey = new SubscriptionsKey();

        LinkedPurchaseListKey linkedPurchaseListKey = new LinkedPurchaseListKey();
        linkedPurchaseListKey.setCourseId(1);
        linkedPurchaseListKey.setStudentId(37);
        LinkedPurchaseList linkedPurchaseList = session.get(LinkedPurchaseList.class, linkedPurchaseListKey);


//        LinkedPurchaseListKey keyLinkedPurchaseList = new LinkedPurchaseListKey(1,1);
//        LinkedPurchaseListKey linkedPurchaseList = session.get(LinkedPurchaseListKey.class, keyLinkedPurchaseList);

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
