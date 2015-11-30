package utils;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class DB {
  private static EntityManager entityManager = null;

  private DB() {
  }

  public static EntityManager getEntityManager() {
    if (entityManager == null) {
      entityManager = Persistence.createEntityManagerFactory("COST1KM").createEntityManager();
      return entityManager;
    } else {
      return entityManager;
    }
  }
}

