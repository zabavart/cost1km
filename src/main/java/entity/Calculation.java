package entity;

import javax.persistence.*;

@Entity
@Table(name = "calculation")
@NamedQuery(name = "Calculation.get", query = "select c from Calculation c")
public class Calculation {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false, unique = true)
  Integer id;

  @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
  @JoinColumn(name = "author_id", nullable = false)
  private Author author;

  @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
  @JoinColumn(name = "car_id", nullable = false)
  private CarModification carId;

  public Calculation() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  public CarModification getCarId() {
    return carId;
  }

  public void setCarId(CarModification carId) {
    this.carId = carId;
  }
}