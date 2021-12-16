package com.osorio.country.entity;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Country {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	//@Column(nullable = false, updatable = false)
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;
	private String name;
	private String capital;
	private String region;
	private String subRegion;
	private Integer area;
	
	public Country() {
	}

	public Country(Long id, String name, String capital, String region, String subRegion, Integer area) {
		super();
		this.id = id;
		this.name = name;
		this.capital = capital;
		this.region = region;
		this.subRegion = subRegion;
		this.area = area;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getSubRegion() {
		return subRegion;
	}

	public void setSubRegion(String subRegion) {
		this.subRegion = subRegion;
	}

	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", capital=" + capital + ", region=" + region + ", subRegion="
				+ subRegion + ", area=" + area + "]";
	}
}
