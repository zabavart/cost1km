package crud;

import entity.TypePeriod;

import javax.persistence.EntityManager;

public class TypePeriodService {
  private EntityManager em;

  public TypePeriodService(EntityManager em) {
    this.em = em;
  }

  public TypePeriod add(TypePeriod typePeriod) {
    em.getTransaction().begin();
    TypePeriod periodFromDB = em.merge(typePeriod);
    em.getTransaction().commit();
    return periodFromDB;
  }

  public void delete(long id) {
    em.getTransaction().begin();
    em.remove(get(id));
    em.getTransaction().commit();
  }

  public TypePeriod get(long id) {
    return em.find(TypePeriod.class, id);
  }

  public void update(TypePeriod typePeriod) {
    em.getTransaction().begin();
    em.merge(typePeriod);
    em.getTransaction().commit();
  }
}