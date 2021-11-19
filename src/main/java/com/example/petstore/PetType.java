package com.example.petstore;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(name = "PetType")
public class PetType {

    @Schema(required = true, description = "Pet type id")
    private Integer petTypeId;

    @Schema(required = true, description = "name")
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPetTypeId() {
        return petTypeId;
    }

    public void setPetTypeId(Integer petId) {
        this.petTypeId = petId;
    }
}
