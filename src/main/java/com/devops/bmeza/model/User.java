package com.devops.bmeza.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@TypeAlias("users")
@Document(collection = "users")
public class User {

  @Id private String id;

  private String name;

  private String password;

  private String role;

}
