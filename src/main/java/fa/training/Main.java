package fa.training;

import fa.training.entity.Department;
import org.hibernate.Session;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.HashMap;

public class Main {
  public static void main(String[] args) {

    try (var registry = new StandardServiceRegistryBuilder()
        .configure("hibernate.cfg.xml")
        .build();
         var sessionFactory = new MetadataSources(registry)
             .addAnnotatedClass(Department.class)
             .buildMetadata().buildSessionFactory()) {

      sessionFactory.inTransaction(Main::doWithSession);
      sessionFactory.inTransaction(Main::doWithSession);
      // Clear cache
      sessionFactory.getCache().evictAllRegions();
      System.out.println("Cache cleared\n");
    }
  }

  private static void doWithSession(Session session) {

    // Do your logic here
    var deps = new HashMap<Integer, Department>();

    for (int i = 0; i < 5; i++) {
      var dep = session.find(Department.class, i + 1);
      deps.put(i+1, dep);
    }

    deps.forEach((key, dep) ->  System.out.printf("Cache exist for: %s : %s\n",
        dep, session.getSessionFactory().getCache().contains(Department.class, key)));
  }
}
