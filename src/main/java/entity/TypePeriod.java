package entity;

import javax.persistence.*;

@Entity
@Table(name = "type_period")
public class TypePeriod {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false, unique = true)
  private Integer id;

  @Column(name = "user_car_id")
  private Integer userCarId;

  @Column(name = "type_period_id")
  private Integer typePeriodId;

  public TypePeriod() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getUserCarId() {
    return userCarId;
  }

  public void setUserCarId(Integer userCarId) {
    this.userCarId = userCarId;
  }

  public Integer getTypePeriodId() {
    return typePeriodId;
  }

  public void setTypePeriodId(Integer typePeriodId) {
    this.typePeriodId = typePeriodId;
  }
}

