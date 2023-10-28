package fa.training;

import fa.training.entity.Department;
import org.hibernate.Session;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
  public static void main(String[] args) {

    try (var registry = new StandardServiceRegistryBuilder().build();
         var sessionFactory = new MetadataSources(registry)
             .addAnnotatedClass(Department.class)
             .buildMetadata().buildSessionFactory()) {

      sessionFactory.inTransaction(Main::doInSession);

    }
  }

  private static void doInSession(Session session) {

    // Do your logic here

    var dep = session.find(Department.class, 1);
    System.out.println(dep.getDeptName());

    var dep2 = session.find(Department.class, 1);
    System.out.println(dep2.getDeptName());

    for (int i = 0; i < 10; i++) {
      System.out.println(session.find(Department.class, 1).getDeptName());
    }

  }
}
