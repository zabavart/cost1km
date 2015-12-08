package crud;

import entity.Calculation;
import entity.CarModification;
import entity.Cost;
import entity.User;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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

  public List<Cost> getByCalculation(Calculation calculation) {
    Query namedQuery = em.createNamedQuery("Calculation.getByCalculation").setParameter("calculation_id", calculation.getId());
    return namedQuery.getResultList();
  }
}