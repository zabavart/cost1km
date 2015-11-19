package entity;

import javax.persistence.*;

@Entity
@Table(name = "car_mark")
@NamedQuery(name = "CarMark.getAll", query = "select c from CarMark c")

public class CarMark {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_car_mark", nullable = false, unique = true)
  private Integer idCarMark;

  @Column(name = "name", length = 32)
  private String name;

  public CarMark(String name) {
    this.name = name;
  }

  public CarMark() {
  }

  public Integer getIdCarMark() {
    return idCarMark;
  }

  public void setIdCarMark(Integer idCarMark) {
    this.idCarMark = idCarMark;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

