package entity;

import javax.persistence.*;

@Entity
@Table(name = "type_period")
public class TypePeriod {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false, unique = true)
  private Integer id;

  @Column(name = "ident", length = 32)
  private String ident;

  @Column(name = "name", length = 32)
  private String name;

  public TypePeriod() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getIdent() {
    return ident;
  }

  public void setIdent(String ident) {
    this.ident = ident;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

