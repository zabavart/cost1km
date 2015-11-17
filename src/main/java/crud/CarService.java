package crud;

import entity.Car;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class CarService {

  public EntityManager em = Persistence.createEntityManagerFactory("COST1KM").createEntityManager();

  public Car add(Car car){
    em.getTransaction().begin();
    Car carFromDB = em.merge(car);
    em.getTransaction().commit();
    return carFromDB;
  }

  public void delete(long id){
    em.getTransaction().begin();
    em.remove(get(id));
    em.getTransaction().commit();
  }

  public Car get(long id){
    return em.find(Car.class, id);
  }

  public void update(Car car){
    em.getTransaction().begin();
    em.merge(car);
    em.getTransaction().commit();
  }

  public List<Car> getAll(){
    Query namedQuery = em.createNamedQuery("Car.getAll");
    return namedQuery.getResultList();
  }

}