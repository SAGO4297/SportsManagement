package com.example.SportsManagement.Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import static javax.persistence.CascadeType.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Club")
public class Club implements Serializable {

  @Id
  @SequenceGenerator(name = "Club_seq", sequenceName = "Club_seq", allocationSize = 1, initialValue = 3000)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Club_seq")
  @Column(name = "ClubId", nullable = false, updatable = false, insertable = false)
  private Integer id;
  private String name;

  @OneToMany(cascade = ALL, mappedBy = "club")
//  @JoinColumn(foreignKey = @ForeignKey(name = "FK_Club_Sport"))
  private List<Player> players;

  @OneToOne(cascade = {PERSIST,REMOVE},
          orphanRemoval = true
  )
  @JoinColumn(
      name = "sport",
      referencedColumnName = "SportId",
      foreignKey = @ForeignKey(name = "FK_Sport_Club")
  )
  private Sport sport;

  public Club(String name, Sport sport1) {
    this.name = name;
    this.sport = sport1;
  }
}
