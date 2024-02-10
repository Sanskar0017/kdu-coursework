package com.kdu.smarthome.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "device")
public class Device{

    @Id
    private String kickstonId;
    private String deviceUsername;
    private String devicePassword;

    /***
     * Many device can belong to one house
     * Many device can belong to one room
     */


    @CreationTimestamp
    private LocalDateTime createdDate;

    @UpdateTimestamp
    private LocalDateTime updatedDate;

    public Device(String kickstoneId, String username, String randomPassword) {
        this.kickstonId = kickstoneId;
        this.deviceUsername = username;
        this.devicePassword = randomPassword;
    }

    @PrePersist
    public void set(){
        createdDate = LocalDateTime.now();
        updatedDate = LocalDateTime.now();
    }

}
