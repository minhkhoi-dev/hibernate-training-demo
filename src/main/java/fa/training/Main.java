package fa.training;

import fa.training.entity.Department;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
  public static void main(String[] args) {

    try (var entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-caching");
        var em = entityManagerFactory.createEntityManager()) {
      EntityTransaction transaction = em.getTransaction();
      try {
        transaction.begin();

        var dep = em.find(Department.class, 1);
        System.out.println(dep.getDeptName());

        var dep2 = em.find(Department.class, 1);
        System.out.println(dep2.getDeptName());

        for (int i = 0; i < 10; i++) {
          System.out.println(em.find(Department.class, 1).getDeptName());
        }

        transaction.commit();
      } catch (Exception e) {
        if (transaction.isActive()) {
          transaction.rollback();
        }
        throw e;
      }
    }
  }
}
