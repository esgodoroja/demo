package com.example.demo.service;

import com.example.demo.models.Pet;
import java.util.Optional;

public interface IPetService {

  Optional<Pet> findById(Long id);

  Pet save(Pet data);

}
