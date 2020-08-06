package com.example.demo.converter.entity;

import com.example.demo.model.CategoryEntity;
import com.example.demo.models.Pet;
import com.example.demo.model.PetEntity;
import com.example.demo.model.enums.PetStatus;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PetEntityConverter implements Converter<Pet, PetEntity> {

  @Override
  public PetEntity convert(Pet source) {
    CategoryEntity categoryEntity = null;

    if (source.getCategory() != null) {
      categoryEntity = new CategoryEntity();
      categoryEntity.setId(source.getCategory().getId());
      categoryEntity.setName(source.getCategory().getName());
    }

    PetEntity entity = new PetEntity();
    entity.setId(source.getId());
    entity.setName(source.getName());
    entity.setStatus(
        (source.getStatus() != null)
            ? PetStatus.valueOf(source.getStatus().name())
            : null);
    entity.setCategory(categoryEntity);

    return entity;
  }
}
