package com.tritux.domain;
import java.io.Serializable;
 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
 
import org.hibernate.validator.constraints.NotEmpty;
 
@Entity
@NamedQueries({
    @NamedQuery(name="TravelTrip.findAll",
                query="SELECT tt FROM TravelTrip tt"),
    @NamedQuery(name="TravelTrip.findByTripType",
                query="SELECT tt FROM TravelTrip tt WHERE tt.business = :business")
}) 
public class TravelTrip implements Serializable {
     
    private static final long serialVersionUID = -8909475486646388460L;
 
    @Id
    @GeneratedValue
    private int id;
 
    @NotNull
    @Size(min = 5, max = 25)
    @Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces")
    private String country;
 
    @NotNull
    @Size(min = 5, max = 25)
    @Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces")
    private String city;
 
    @NotNull
    @NotEmpty
    private String fromDate;
 
    @NotNull
    @NotEmpty
    private String toDate;
 
    private boolean business;
 
    public TravelTrip() {
 
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getCountry() {
        return country;
    }
 
    public void setCountry(String country) {
        this.country = country;
    }
 
    public String getCity() {
        return city;
    }
 
    public void setCity(String city) {
        this.city = city;
    }
 
    public String getFromDate() {
        return fromDate;
    }
 
    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }
 
    public String getToDate() {
        return toDate;
    }
 
    public void setToDate(String toDate) {
        this.toDate = toDate;
    }
 
    public boolean isBusiness() {
        return business;
    }
 
    public void setBusiness(boolean business) {
        this.business = business;
    }
}