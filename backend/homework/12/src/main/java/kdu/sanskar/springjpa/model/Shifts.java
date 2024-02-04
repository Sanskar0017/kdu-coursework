package kdu.sanskar.springjpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;
import java.util.UUID;
/**
 * Represents a shift entity in the system.
 * Extends CommonColumnToAll to inherit common columns.
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "shifts")
public class Shifts extends CommonColumnToAll{

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "shift_type_id")
    private ShiftTypes shiftTypes;
    private String name;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    @Column(name = "start_time")
    private Time startTime;
    @Column(name = "end_time")
    private Time endTime;

    @ManyToOne
    @JoinColumn(name = "tenant_id")
    private Tenants tenant;
}
