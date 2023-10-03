package com.example.SportsManagement.Entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import static javax.persistence.CascadeType.ALL;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Sport",
    uniqueConstraints = {
            @UniqueConstraint(name = "sport_name_unique",columnNames = {"Name"})
    }
)
public class Sport implements Serializable {

  @Id
  @SequenceGenerator(name = "sport_id_seq", sequenceName = "sport_id_seq", allocationSize = 1,initialValue =1000 )
  @GeneratedValue(generator = "sport_id_seq", strategy = GenerationType.SEQUENCE)
  @Column(name = "SportId")
  private Integer id;

  @Column(name = "Name")
  private String name;

  public Sport(String sport) {
    this.name = sport;
  }
}
