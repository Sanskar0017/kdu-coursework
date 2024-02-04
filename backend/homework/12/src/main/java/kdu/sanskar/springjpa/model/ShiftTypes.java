package kdu.sanskar.springjpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;
/**
 * Represents a shift type entity with common columns.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "shift_types")
public class ShiftTypes extends CommonColumnToAll{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String uqName;
    private String description;
    private Boolean active;
    private String timeZone;

    @ManyToOne
    @JoinColumn(name = "tenant_id")
    private Tenants tenants;

}
