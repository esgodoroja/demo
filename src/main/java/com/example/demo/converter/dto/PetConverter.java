package com.example.demo.converter.dto;

import com.example.demo.models.Category;
import com.example.demo.models.Pet;
import com.example.demo.models.Pet.StatusEnum;
import com.example.demo.model.PetEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PetConverter implements Converter<PetEntity, Pet> {

  @Override
  public Pet convert(PetEntity source) {
    Category category = (source.getCategory() != null)
        ? new Category().id(source.getCategory().getId()).name(source.getCategory().getName())
        : null;
    StatusEnum status = (source.getStatus() != null)
        ? StatusEnum.valueOf(source.getStatus().name()) : null;
    return new Pet()
        .id(source.getId())
        .name(source.getName())
        .category(category)
        .status(status);
  }
}
