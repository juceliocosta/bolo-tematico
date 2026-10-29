package com.java.bolo_tematico.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")

public class User {
    @Id
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;
}
