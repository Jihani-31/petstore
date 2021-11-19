package com.example.petstore;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

@Schema(name = "Pet")
public class Pet {

	@Schema(required = true, description = "Pet id")
	private Integer petId;

	@Schema(required = true, description = "Pet type")
	private PetType petType;

	@Schema(required = true, description = "Pet name")
	private String petName;

	@Schema(required = true, description = "Pet age")
	private Integer petAge;

	public Integer getPetId() {
		return petId;
	}

	public void setPetId(Integer petId) {
		this.petId = petId;
	}

	public PetType getPetType() {
		return petType;
	}

	public void setPetType(PetType petType) {
		this.petType = petType;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public Integer getPetAge() {
		return petAge;
	}

	public void setPetAge(Integer petAge) {
		this.petAge = petAge;
	}

}
