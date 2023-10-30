package fa.training;

import fa.training.entity.Department;
import org.hibernate.Session;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
  public static void main(String[] args) {

    try (var registry = new StandardServiceRegistryBuilder()
        .configure("hibernate.cfg.xml")
        .build();
         var sessionFactory = new MetadataSources(registry)
             .buildMetadata().buildSessionFactory()) {

      sessionFactory.inTransaction(Main::doWithSession);
      System.out.println("---------------------------------");
      sessionFactory.inTransaction(Main::doWithSession);

      // Clear cache
      sessionFactory.getCache().evictAllRegions();
      System.out.println("Cache cleared\n");
      System.out.println("---------------------------------");
      System.out.printf("Cache exist for: id=%s : %s\n", 2,
              sessionFactory.getCache().contains(Department.class, 2));
    }
  }

  private static void doWithSession(Session session) {

    // Do your logic here
    var result = session.createQuery("select d from Department d where d.id = :id", Department.class)
            .setParameter("id", 2)
            .setCacheable(true)
            .getSingleResult();

    System.out.printf("Cache exist for query: id=%s: %s : %s\n", 2, result,
            session.getSessionFactory().getCache().contains(Department.class, 2));
  }
}
