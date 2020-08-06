package com.example.demo.controller;

import com.example.demo.apis.UserApi;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserApi {

  @Override
  public ResponseEntity<String> loginUser(@NotNull @Valid String username,
      @NotNull @Valid String password) {
    return null;
  }

  @Override
  public ResponseEntity<Void> logoutUser() {
    return null;
  }
}
