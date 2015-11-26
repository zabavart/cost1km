package crud;

import entity.Period;

import javax.persistence.EntityManager;

public class PeriodService {
  private EntityManager em;

  public PeriodService(EntityManager em) {
    this.em = em;
  }

  public Period merge(Period period) {
    em.getTransaction().begin();
    Period periodFromDB = em.merge(period);
    em.getTransaction().commit();
    return periodFromDB;
  }

  public void delete(Integer id) {
    em.getTransaction().begin();
    em.remove(get(id));
    em.getTransaction().commit();
  }

  public Period get(Integer id) {
    return em.find(Period.class, id);
  }

  public void update(Period period) {
    em.getTransaction().begin();
    em.merge(period);
    em.getTransaction().commit();
  }
}