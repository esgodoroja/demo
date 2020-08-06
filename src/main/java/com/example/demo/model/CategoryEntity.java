package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "category")
public class CategoryEntity {

  @Id
  private Long id = null;

  @Column(nullable = false, unique = true)
  private String name = null;
}
