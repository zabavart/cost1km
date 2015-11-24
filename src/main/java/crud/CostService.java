package crud;

import entity.Cost;
import org.json.simple.JSONObject;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class CostService {
  private EntityManager em;

  public CostService(EntityManager em) {
    this.em = em;
  }

  public Cost add(Cost cost) {
    em.getTransaction().begin();
    Cost costFromDB = em.merge(cost);
    em.getTransaction().commit();
    return costFromDB;
  }

  public void delete(long id) {
    em.getTransaction().begin();
    em.remove(get(id));
    em.getTransaction().commit();
  }

  public Cost get(long id) {
    return em.find(Cost.class, id);
  }

  public void update(Cost cost) {
    em.getTransaction().begin();
    em.merge(cost);
    em.getTransaction().commit();
  }
}