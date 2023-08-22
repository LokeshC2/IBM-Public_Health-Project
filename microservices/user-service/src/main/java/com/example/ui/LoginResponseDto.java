package com.example.ui;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponseDto {
  private int id;
  private String username;
  private String role;
  private Boolean loggedIn;
}
