package org.wecancodeit.restingcities;

import java.util.Collection;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class State {

	@Id
	@GeneratedValue
	private Long id;

	private String name;
	private String abbreviation;
	private String motto;
	private String citiesUrl;

	@JsonIgnore
	@OneToMany(mappedBy = "state")
	private Collection<City> cities;

	@Embedded
	private Fish fish;

	public State() {
	}

	public State(String name, String abbreviation, String motto, String citiesUrl, Fish fish) {
		this.name = name;
		this.abbreviation = abbreviation;
		this.motto = motto;
		this.citiesUrl = citiesUrl;
		this.fish = fish;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public String getMotto() {
		return motto;
	}

	public String getCitiesUrl() {
		return citiesUrl;
	}

	public Collection<City> getCities() {
		return cities;
	}

	public Fish getFish() {
		return fish;
	}

	@Override
	public String toString() {
		return name;
	}

}
