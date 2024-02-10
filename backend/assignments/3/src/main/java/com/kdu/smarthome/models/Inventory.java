package com.kdu.smarthome.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Model class representing an Inventory entity.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    @JsonProperty("kickston_id")
    private String kickstonId;
    private String deviceUsername;
    private String devicePassword;
    private String manufactureDateTime;
    private String manufactureFactoryPlace;

    @CreationTimestamp
    private LocalDateTime createdDate;

    @UpdateTimestamp
    private LocalDateTime updatedDate;

    /**
     * Constructor with parameters.
     *
     * @param kickstoneId             The ID of the kickstone.
     * @param deviceUsername          The username of the device.
     * @param devicePassword          The password of the device.
     * @param manufactureDateTime     The manufacturing date and time.
     * @param manufactureFactoryPlace The manufacturing factory place.
     */
    public Inventory(String kickstoneId, String deviceUsername, String devicePassword, String manufactureDateTime, String manufactureFactoryPlace) {
        this.kickstonId = kickstoneId;
        this.deviceUsername = deviceUsername;
        this.devicePassword = devicePassword;
        this.manufactureDateTime = manufactureDateTime;
        this.manufactureFactoryPlace = manufactureFactoryPlace;
    }
}
