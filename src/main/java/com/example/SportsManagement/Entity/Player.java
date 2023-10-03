package com.example.SportsManagement.Entity;

import static javax.persistence.CascadeType.ALL;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Player")
public class Player implements Serializable {

  @Id
  @SequenceGenerator(name = "Player_seq", sequenceName = "Player_seq", allocationSize = 1, initialValue = 2000)
  @GeneratedValue(generator = "Player_seq", strategy = GenerationType.SEQUENCE)
  @Column(name = "PlayerId",
      nullable = false,
      updatable = false,
      insertable = false
  )
  private Integer id;

  @Column(name = "Name")
  private String name;

  @Column(name = "Age")
  private Integer age;

  @Column(name = "Gender")
  private String gender;

  @OneToOne(cascade = ALL)
  @JoinColumn( name = "sport",
      referencedColumnName = "SportId",
      nullable = false,
      foreignKey = @ForeignKey(name = "FK_Sport_Player")
  )
  private Sport sport;

  @ManyToOne(cascade = ALL)
  @JoinColumn(name = "club",
      referencedColumnName = "ClubId",
      nullable = false,
      foreignKey = @ForeignKey(name = "FK_Club_Player")
  )
  private Club club;

  @Column(name = "DateOfJoining")
  private Date dateOfJoining;

  @Column(name = "IsActive")
  private boolean isActive;

  public Player(String name,  Sport sport, String gender, Club club,Integer age) {
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.sport = sport;
    this.club = club;
    this.dateOfJoining = new Date();
    this.isActive = true;
  }
}
