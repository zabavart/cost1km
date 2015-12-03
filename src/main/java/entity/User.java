package entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false, unique = true)
  private Integer id;

  @Column(name = "name", length = 32)
  private String name;

  @Column(name = "login", length = 32)
  private String login;

  @Column(name = "password", length = 32)
  private String password;

//  @OneToMany(fetch = FetchType.EAGER, mappedBy = "user_car`")
//  private Set<UserCar> UserCars;

  public User() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

//  public Set<UserCar> getUserCars() {
//    return UserCars;
//  }
//
//  public void setUserCars(Set<UserCar> userCars) {
//    UserCars = userCars;
//  }
}

