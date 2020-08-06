package com.example.demo.model;

import com.example.demo.model.enums.PetStatus;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "pet")
public class PetEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne
  private CategoryEntity category;

  @Column(nullable = false)
  private String name;

  @Enumerated(EnumType.STRING)
  private PetStatus status;

}
