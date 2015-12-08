package entity;

import javax.persistence.*;

@Entity
@Table(name = "calculation")
@NamedQueries({
    @NamedQuery(name = "Calculation.get",
        query = "select c from Calculation c"),
    @NamedQuery(name = "Calculation.getByUserAndCarModification",
        query = "select c from Calculation c where car_id = :car_id and user_id = :user_id"),
})
public class Calculation {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false, unique = true)
  Integer id;

  @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
  @JoinColumn(name = "car_id", nullable = false)
  private CarModification carModification;

  public Calculation() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public CarModification getCarModification() {
    return carModification;
  }

  public void setCarModification(CarModification carId) {
    this.carModification = carId;
  }
}