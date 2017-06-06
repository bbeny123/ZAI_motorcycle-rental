package beny.spring.model;

import org.apache.tomcat.util.codec.binary.Base64;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created Beny on 03.06.2017.
 */

@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "MOTORCYCLES")
@SequenceGenerator(name = "SEQ_MTO_ID", sequenceName = "SEQ_MTO_ID", allocationSize = 1)
public class MotorcycleData {

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "motorcycle", cascade = {CascadeType.ALL})
    private List<RentData> rents;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MTO_ID")
    @Column(name = "MTO_ID")
    private Long id;

    @Column(name = "MTO_MANUFACTURER", length = 20, nullable = false)
    private String manufacturer;

    @Column(name = "MTO_MODEL", length = 20, nullable = false)
    private String model;

    @Column(name = "MTO_YEAR", nullable = false)
    private int productionYear;

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

    @Column(name = "MTO_PHOTO_BASE64")
    @Lob
    private String photoString;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
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
        if(photo != null) {
            photoString = Base64.encodeBase64String(photo);
            this.photo = photo;
        }
    }

    public String getPhotoString() {
        return photoString;
    }

    public void setPhotoString(String photoString) {
        if(photoString.length() != 0)
           this.photoString = photoString;
    }

    public List<RentData> getRent() {
        if(rents == null) {
            rents = new ArrayList<>();
        }
        return rents;
    }

    public void setRent(List<RentData> rents) {
        this.rents = rents;
    }

    public boolean isAvailable() {
        for (RentData rent : rents) {
            if(rent.getStatus().equals(RentData.Statuses.ACTIVE)) {
                return false;
            }
        }
        return true;
    }
}
