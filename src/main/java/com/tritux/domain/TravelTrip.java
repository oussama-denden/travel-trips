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

/**
 * Travel Class entity.
 * 
 * @author Denden-OUSSAMA
 * 
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "TravelTrip.findAll", query = "SELECT tt FROM TravelTrip tt"),
		@NamedQuery(name = "TravelTrip.findByTripType", query = "SELECT tt FROM TravelTrip tt WHERE tt.business = :business") })
public class TravelTrip implements Serializable {

	/**
	 * serialization UID.
	 */
	private static final long serialVersionUID = -8909475486646388460L;

	/**
	 * id.
	 */
	@Id
	@GeneratedValue
	private int id;

	/**
	 * country name.
	 */
	@NotNull
	@Size(min = 5, max = 25)
	@Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces")
	private String country;

	/**
	 * city name.
	 */
	@NotNull
	@Size(min = 5, max = 25)
	@Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces")
	private String city;

	/**
	 * depart date.
	 */
	@NotNull
	@NotEmpty
	private String fromDate;

	/**
	 * arrival date.
	 */
	@NotNull
	@NotEmpty
	private String toDate;

	/**
	 * trip type business/leisure.
	 */
	private boolean business;

	/**
	 * empty constructor.
	 */
	public TravelTrip() {

	}

	/**
	 * id getter.
	 * 
	 * @return id.
	 */
	public int getId() {
		return id;
	}

	/**
	 * id setter.
	 * 
	 * @param id
	 *            id.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * country name getter.
	 * 
	 * @return country name.
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * country name setter.
	 * 
	 * @param country
	 *            country name.
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * city name getter.
	 * 
	 * @return city name.
	 */
	public String getCity() {
		return city;
	}

	/**
	 * city name setter.
	 * 
	 * @param city
	 *            city name.
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * depart date getter.
	 * 
	 * @return depart date.
	 */
	public String getFromDate() {
		return fromDate;
	}

	/**
	 * depart date setter.
	 * 
	 * @param fromDate
	 *            depart date.
	 */
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	/**
	 * arrival date getter.
	 * 
	 * @return arrival date.
	 */
	public String getToDate() {
		return toDate;
	}

	/**
	 * arrival date setter.
	 * 
	 * @param toDate
	 *            arrival date.
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	/**
	 * trip type getter.
	 * 
	 * @return trip type.
	 */
	public boolean isBusiness() {
		return business;
	}

	/**
	 * 
	 * trip type setter.
	 * 
	 * @param business
	 *            trip type business/leisure.
	 */
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