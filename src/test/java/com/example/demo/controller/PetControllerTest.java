package com.example.demo.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demo.DemoApplication;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@AutoConfigureMockMvc(addFilters = false)
@SpringBootTest(classes = DemoApplication.class)
class PetControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void addPet_with_response_ok() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/v2/pet")
        .contentType(MediaType.APPLICATION_JSON)
        .content(
            "{\"category\":{\"id\":1,\"name\":\"Category 1\"},\"name\":\"dog 2\",\"status\":\"available\"}")
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andReturn();
  }

  @Test
  @Disabled(value = "need to check validation")
  void addPet_with_response_bad_request() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/v2/pet")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"category\":{\"id\":1,\"name\":\"Category 1\"},\"status\":\"available\"}")
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest())
        .andReturn();
  }

  @Test
  void deletePet() {
  }

  @Test
  void findPetsByStatus() {
  }

  // TODO: add properties check
  @Test
  void getPetById_with_response_ok() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/v2/pet/1")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  void getPetById_with_response_not_found() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/v2/pet/0")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound());
  }

  @Test
  void getPetById_with_wrong_input() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/v2/pet/wrong")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest());
  }

  @Test
  void updatePet() {
  }

  @Test
  void updatePetWithForm() {
  }
}
