package crud;

import entity.Calculation;
import entity.CarModel;
import entity.CarModification;
import entity.User;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class CalculationService {
  private EntityManager em;

  public CalculationService(EntityManager em) {
    this.em = em;
  }

  public Calculation merge(Calculation calculation) {
    em.getTransaction().begin();
    Calculation calculationFromDB = em.merge(calculation);
    em.getTransaction().commit();
    return calculationFromDB;
  }

  public void delete(Integer id) {
    em.getTransaction().begin();
    em.remove(get(id));
    em.getTransaction().commit();
  }

  public Calculation get(Integer id) {
    return em.find(Calculation.class, id);
  }

  public List<Calculation> get() {
    Query namedQuery = em.createNamedQuery("Calculation.get");
    return namedQuery.getResultList();
  }

  public void update(Calculation calculation) {
    em.getTransaction().begin();
    em.merge(calculation);
    em.getTransaction().commit();
  }

  public List<Calculation>  getByUserAndCarModification(CarModification carModification, User user) {
    Query namedQuery = em.createNamedQuery("Calculation.getByUserAndCarModification")
        .setParameter("car_id", carModification.getIdCarModification())
        .setParameter("user_id", user.getId());
    return namedQuery.getResultList();
  }
}