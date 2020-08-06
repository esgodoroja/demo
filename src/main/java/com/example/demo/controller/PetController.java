package com.example.demo.controller;

import com.example.demo.apis.PetApi;
import com.example.demo.models.Pet;
import com.example.demo.service.IPetService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetController implements PetApi {

  private final IPetService service;

  public PetController(IPetService service) {
    this.service = service;
  }

  @Override
  public ResponseEntity<Pet> addPet(Pet body) {
    return ResponseEntity.ok(service.save(body));
  }

  @Override
  public ResponseEntity<Void> deletePet(Long petId, String apiKey) {
    return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
  }

  @Override
  public ResponseEntity<List<Pet>> findPetsByStatus(List<String> status) {
    return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
  }

  @Override
  public ResponseEntity<Pet> getPetById(Long petId) {
    return
        service.findById(petId).map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
  }

  @Override
  public ResponseEntity<Void> updatePet(Pet body) {
    return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
  }

  @Override
  public ResponseEntity<Void> updatePetWithForm(Long petId, String name, String status) {
    return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
  }
}
