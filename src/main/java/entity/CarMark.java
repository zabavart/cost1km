package entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "car_mark")
@NamedQuery(name = "CarMark.getAll", query = "SELECT c from CarMark c")
public class CarMark {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id_car_mark;

  @Column(name = "name", length = 32)
  private String name;      //Название авто


  public CarMark(String name) {
    this.name = name;
  }

  public CarMark() {
  }

  public long getIdCarMark() {
    return id_car_mark;
  }

  public void setId_car_mark(long id_car_mark) {
    this.id_car_mark = id_car_mark;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
