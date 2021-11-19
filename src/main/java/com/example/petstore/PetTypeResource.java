package com.example.petstore;

import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/v1/petTypes")
@Produces("application/json")
public class PetTypeResource {


    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "All PetTypes", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "PetType")))})
    @GET
    public Response getPetTypes() {
        List<PetType> petTypes = ResourcesManage.getPetTypes();
        return Response.ok(petTypes).build();
    }

    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Pet type for id", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "PetType"))),
            @APIResponse(responseCode = "404", description = "No Pet type found for the id.")})
    @GET
    @Path("{petTypeId}")
    public Response getPetType(@PathParam("petTypeId") int petTypeId) {

        PetType petType = ResourcesManage.getPetType(petTypeId);
        if(petType==null){
            return Response.ok().build();
        }else{
            return Response.ok(petType).build();
        }
    }

    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Pet has added", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))),
            @APIResponse(responseCode = "404", description = "Pet type is already in the list.")
    })
    @POST
    public Response addPetType(@RequestBody(required = true) PetType petType) {

        if(ResourcesManage.addPetType(petType)){
            return Response.ok(petType).build();
        }else{
            return Response.ok().build();
        }
    }

    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Pet has added"),
            @APIResponse(responseCode = "404", description = "No Pet type found for the id.")
    })
    @POST
    @Path("{petTypeId}")
    public Response updatePetType(@PathParam("petTypeId") int petId, @RequestBody(required = true) PetType petType) {

        if(ResourcesManage.updatePetType(petType)){
            return Response.ok(petType).build();
        }else{
            return Response.ok().build();
        }
    }

    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Pet has deleted"),
            @APIResponse(responseCode = "404", description = "No Pet type found for the id.")})
    @DELETE
    @Path("{petTypeId}")
    public Response deletePetType(@PathParam("petTypeId") int petTypeId) {

        if(ResourcesManage.deletePetType(petTypeId)){
            return Response.ok().build();
        }else{
            return Response.noContent().build();
        }


    }
}
