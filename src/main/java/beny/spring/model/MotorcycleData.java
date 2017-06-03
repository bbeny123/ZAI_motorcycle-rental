package beny.spring.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created Beny on 03.06.2017.
 */

@Entity
@Table(name = "MOTORCYCLES")
@SequenceGenerator(name = "SEQ_MTO_ID", sequenceName = "SEQ_MTO_ID", allocationSize = 1)
public class MotorcycleData {

    @OneToMany(mappedBy = "motorcycle")
    private Set<RentData> rent;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MTO_ID")
    @Column(name = "MTO_ID")
    private long id;

    @Column(name = "MTO_MANUFACTURER", length = 20, nullable = false, updatable = false)
    private String manufacturer;

    @Column(name = "MTO_MODEL", length = 20, nullable = false)
    private String model;

    @Column(name = "MTO_CAPACITY", nullable = false)
    private int capacity;

    @Column(name = "MTO_POWER", nullable = false)
    private int power;

    @Column(name = "MTO_WEIGHT", nullable = false)
    private int weight;

    @Column(name = "MTO_CONSUMPTION", nullable = false)
    private double consumption;

    @Column(name = "MTO_TOP_SPEED", nullable = false)
    private int topSpeed;

    @Column(name = "MTO_COLOUR", length = 20, nullable = false)
    private String colour;

    @Column(name = "MTO_PRICE", nullable = false)
    private int price;

    @Column(name = "MTO_PHOTO")
    @Lob
    private byte[] photo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Set<RentData> getRent() {
        if(rent == null) {
            rent = new HashSet<>();
        }
        return rent;
    }

    public void setRent(Set<RentData> rent) {
        this.rent = rent;
    }

}