package com.project.passwordpolicy.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user_table")
@Data
public class User {

    @Id
    Long id;

    String userName;
    String password;
    String roleName;

}
