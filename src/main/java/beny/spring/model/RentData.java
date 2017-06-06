package beny.spring.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Beny on 03.06.2017.
 */

@Entity
@Table(name = "RENTS")
@SequenceGenerator(name = "SEQ_RNT_ID", sequenceName = "SEQ_RNT_ID", allocationSize = 1)
public class RentData {

    public interface Statuses {
        String ACTIVE = "Active";        				/** Active */
        String CANCELED = "Canceled";  	                /** Canceled */
        String FINISHED = "Finished";       			/** Finished */
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_RNT_ID")
    @Column(name = "RNT_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "RNT_USR_ID")
    private UserData user;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "RNT_MTO_ID")
    private MotorcycleData motorcycle;

    @Column(name = "RNT_STATUS", length = 10, nullable = false)
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserData getUser() {
        return user;
    }

    public void setUser(UserData user) {
        this.user = user;
    }

    public MotorcycleData getMotorcycle() {
        return motorcycle;
    }

    public void setMotorcycle(MotorcycleData motorcycle) {
        this.motorcycle = motorcycle;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
