package com.kdu.smarthome.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Model class representing a User entity.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users {

    @Id
    @Column(name = "user_id")
    private int id;
    private String username;
    private String password;
    private String name;
    private String firstName;
    private String lastName;
    private String emailId;
    private String role = "ROLE_USER";

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<House> houseList = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime createdDate;

    @UpdateTimestamp
    private LocalDateTime updatedDate;
}
