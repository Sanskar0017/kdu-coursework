package com.kdu.smarthome.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Model class representing a Room entity.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String roomName;

    @OneToMany
    private List<Device> deviceList = new ArrayList<>();

    @CreatedDate
    private LocalDateTime createdDate;

    @CreatedDate
    private LocalDateTime updatedDate;
}
