package com.tritux.domain;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

@Entity
@NamedQueries({
		@NamedQuery(name = "TravelTrip.findAll", query = "SELECT tt FROM TravelTrip tt"),
		@NamedQuery(name = "TravelTrip.findByTripType", query = "SELECT tt FROM TravelTrip tt WHERE tt.business = :business") })
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

	/**
	 * Serialize a travel trip object to a string.
	 * 
	 * @return string representation of the travel trip object.
	 */
	public String toJson() {
		return new JSONSerializer().exclude("*.class").serialize(this);
	}

	/**
	 * 
	 * Transform a string into a travel trip object.
	 * 
	 * @param json
	 *            string representation of the travel trip.
	 * @return {@link TravelTrip}
	 */
	public static TravelTrip fromJsonToActivityBranch(String json) {
		return new JSONDeserializer<TravelTrip>().use(null, TravelTrip.class)
				.deserialize(json);
	}

	/**
	 * Serialize a collection of travel trip object to a string.
	 * 
	 * @param collection
	 *            the collection to be translated to a string.
	 * @return string representation of the travel trip collection.
	 */
	public static String toJsonArray(Collection<TravelTrip> collection) {
		return new JSONSerializer().exclude("*.class").serialize(collection);
	}

	/**
	 * 
	 * Transform a string into a travel trip collection.
	 * 
	 * @param json
	 *            string representation of the collection of travel trip.
	 * @return collection of {@link TravelTrip}
	 */
	public static Collection<TravelTrip> fromJsonArrayToActivityBranches(
			String json) {
		return new JSONDeserializer<List<TravelTrip>>()
				.use(null, ArrayList.class).use("values", TravelTrip.class)
				.deserialize(json);
	}
}