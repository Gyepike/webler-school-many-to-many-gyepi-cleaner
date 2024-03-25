package com.anti.weblerschoolmanytomanygyepi.controller;

import com.anti.weblerschoolmanytomanygyepi.model.UserModel;
import com.anti.weblerschoolmanytomanygyepi.model.UserRegistrationModel;
import com.anti.weblerschoolmanytomanygyepi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class UserController {

   private final UserService userService;

   @GetMapping("/users")
   public ResponseEntity<List<UserModel>> renderAllUsers() {
      return ResponseEntity.status(200).body(userService.findAllUsers());
   }

   @PostMapping("/users")
   public ResponseEntity<UserModel> createNewUser(@RequestBody UserRegistrationModel userRegistrationModel) {
      return ResponseEntity.status(201).body(userService.createUser(userRegistrationModel));
   }

   @GetMapping("/users/{id}")
   public ResponseEntity<UserModel> renderUserById(@PathVariable(name = "id") Long id) {
      return ResponseEntity.status(200).body(userService.findUserById(id));
   }
}
