package com.example.demo.service;

import com.example.demo.models.Pet;
import com.example.demo.model.PetEntity;
import com.example.demo.repository.IPetRepository;
import java.util.Optional;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class PetService implements IPetService {

  private final IPetRepository petRepository;
  private final ConversionService conversionService;

  public PetService(IPetRepository petRepository,
      ConversionService conversionService) {
    this.petRepository = petRepository;
    this.conversionService = conversionService;
  }

  @Override
  public Optional<Pet> findById(Long id) {
    return petRepository.findById(id)
        .map(it -> conversionService.convert(it, Pet.class));
  }

  @Override
  public Pet save(Pet data) {
    PetEntity result = petRepository.save(conversionService.convert(data, PetEntity.class));
    return data.id(result.getId());
  }
}
