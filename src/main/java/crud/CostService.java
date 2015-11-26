package crud;

import entity.Cost;

import javax.persistence.EntityManager;

public class CostService {
  private EntityManager em;

  public CostService(EntityManager em) {
    this.em = em;
  }

  public Cost merge(Cost cost) {
    em.getTransaction().begin();
    Cost periodFromDB = em.merge(cost);
    em.getTransaction().commit();
    return periodFromDB;
  }

  public void delete(Integer id) {
    em.getTransaction().begin();
    em.remove(get(id));
    em.getTransaction().commit();
  }

  public Cost get(Integer id) {
    return em.find(Cost.class, id);
  }

  public void update(Cost cost) {
    em.getTransaction().begin();
    em.merge(cost);
    em.getTransaction().commit();
  }
}