package crud;

import entity.CarModel;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class CarModelService {
  private EntityManager em;

  public CarModelService(EntityManager em) {
    this.em = em;
  }

  public CarModel add(CarModel carModel) {
    em.getTransaction().begin();
    CarModel carModelFromDB = em.merge(carModel);
    em.getTransaction().commit();
    return carModelFromDB;
  }

  public void delete(long id) {
    em.getTransaction().begin();
    em.remove(get(id));
    em.getTransaction().commit();
  }

  public CarModel get(long id) {
    return em.find(CarModel.class, id);
  }

  public CarModel getByIdCarMark(long idCarMark) {
    return em.find(CarModel.class, idCarMark);
  }

  public void update(CarModel carModel) {
    em.getTransaction().begin();
    em.merge(carModel);
    em.getTransaction().commit();
  }

  public List<CarModel> getAll() {
    Query namedQuery = em.createNamedQuery("CarModel.getAll");
    return namedQuery.getResultList();
  }
}