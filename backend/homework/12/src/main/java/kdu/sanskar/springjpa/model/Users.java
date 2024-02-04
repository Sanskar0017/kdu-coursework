package kdu.sanskar.springjpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;
/**
 * Represents a user entity with common columns.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class Users extends CommonColumnToAll{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String userName;
    private int loggedIn;
    private String timeZone;

    @ManyToOne
    @JoinColumn(name = "tenant_id")
    private Tenants tenants;
}
