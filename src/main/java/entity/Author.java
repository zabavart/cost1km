package entity;


import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "author")
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false, unique = true)
  private Integer id;

  @Column(name = "name")
  private String name;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "author")
  private Set<Calculation> calculations;

  public Author() {
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

  public Set<Calculation> getCalculations() {
    return calculations;
  }

  public void setCalculations(Set<Calculation> calculations) {
    this.calculations = calculations;
  }
}