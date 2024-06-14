package com.kdu.smarthome.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
 * Model class representing a House entity.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "house")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String address;
    private String houseName;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private Users user;

    @OneToMany(fetch = FetchType.EAGER)
    @JsonBackReference
    private List<Users> usersList = new ArrayList<>();

    @OneToMany
    private List<Room> roomList = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime createdDate;

    @UpdateTimestamp
    private LocalDateTime updatedDate;

    /**
     * Constructor with parameters.
     *
     * @param address    The address of the house.
     * @param houseName  The name of the house.
     * @param byUsername The user who owns the house.
     */
    public House(String address, String houseName, Users byUsername) {
        this.address = address;
        this.houseName = houseName;
        this.user = byUsername;
    }

    /**
     * Get the name of the user who owns the house.
     *
     * @return The name of the user.
     */
    public String getUserName() {
        return user.getName();
    }
}
