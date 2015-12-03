package entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "user_car")
@NamedQuery(name = "UserCar.get", query = "SELECT uc from UserCar uc")
public class UserCar {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false, unique = true)
  private Integer id;

  @Column(name = "user_id")
  private Integer userId;

  @Column(name = "car_id")
  private Integer carId;

//  @OneToOne(optional = false, mappedBy="user")
//  private User user;

  public UserCar() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Integer getCarId() {
    return carId;
  }

  public void setCarId(Integer carId) {
    this.carId = carId;
  }

//  public User getUser() {
//    return user;
//  }
//
//  public void setUser(User user) {
//    this.user = user;
//  }
}

