package kdu.sanskar.springjpa.model;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import lombok.Data;

import java.util.Date;

/**
 * Class with super attributes present in all entity tables
 * Inheriting all such attributes in all such class extending the Same.
 */
@Data
@MappedSuperclass
public class CommonColumnToAll {

    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "updated_by")
    private String updatedBy;

    @PrePersist
    public void set(){
        createdAt = new Date();
        updatedAt = new Date();
    }


}
