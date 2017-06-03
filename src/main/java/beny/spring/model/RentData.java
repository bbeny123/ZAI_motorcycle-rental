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

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_RNT_ID")
    @Column(name = "RNT_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "USR_ID")
    private UserData user;

    @ManyToOne
    @JoinColumn(name = "MTO_ID")
    private MotorcycleData motorcycle;

    @Column(name = "RNT_DATE_START", nullable = false)
    private Date dateStart;

    @Column(name = "RNT_DATE_END", nullable = false)
    private Date dateEnd;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

}
