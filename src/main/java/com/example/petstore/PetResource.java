package com.example.petstore;


import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@Path("/v1/pets")
@Produces("application/json")
public class PetResource {

    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "All Pets", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet")))})
    @GET
    public Response getPets() {
        List<Pet> pets = ResourcesManage.getPets();
        return Response.ok(pets).build();
    }

    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Pet for id", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))),
            @APIResponse(responseCode = "404", description = "No Pet found for the id.")})
    @GET
    @Path("{petId}")
    public Response getPet(@PathParam("petId") int petId) {

        Pet pet = ResourcesManage.getPet(petId);
        if(pet==null){
            return Response.ok().build();
        }else{
            return Response.ok(pet).build();
        }
    }

    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Pet has added", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))),
            @APIResponse(responseCode = "404", description = "Pet is already in the list or invalid pet type .")
    })
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPet(@RequestBody(required = true) Pet pet) {
        if(ResourcesManage.addPet(pet)){
            return Response.ok(pet).build();
        }else{
            return Response.status(400).build();
        }
    }

    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Pet has added"),
            @APIResponse(responseCode = "404", description = "No Pet found for the id.")
    })
    @POST
    @Path("{petId}")
    public Response updatePet(@PathParam("petId") int petId, @RequestBody(required = true) Pet pet) {
        if(ResourcesManage.updatePet(pet)){
            return Response.ok(pet).build();

        }else{
            return Response.ok().build();
        }
    }

    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Pet has deleted"),
            @APIResponse(responseCode = "404", description = "No Pet found for the id.")})
    @DELETE
    @Path("{petId}")
    public Response deletePet(@PathParam("petId") int petId) {
        if(ResourcesManage.deletePet(petId)){
            return Response.ok().build();
        }else{
            return Response.ok().build();
        }
    }

}
