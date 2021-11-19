package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.allOf;

@QuarkusTest
public class PetResourceTest {

    @Test
    public void testGetPets() {
        given()
                .when().get("/v1/pets")
                .then()
                .statusCode(200);
    }

    @Test
    public void testGetPet() {
        given()
                .when().get("/v1/pets/")
                .then()
                .statusCode(200);
    }
    //1


    //2
//    @Test
//    void testPetEndpointSuccess()
//    {
//        given()
//                .when().get( "/pets" )
//                .then()
//                .assertThat()
//                .statusCode( 200 )
//                .body( "petId", notNullValue() )
//                .body( "petAge", equalTo( new ArrayList()
//                {{
//                    add( 5 );
//                    add( 4 );
//                    add( 2 );
//                }} ) )
//                .body( "petName", equalTo( new ArrayList()
//                {{
//                    add( "boola" );
//                    add( "sudda" );
//                    add( "boola" );
//                }} ) )
//                .body( "petType", equalTo( new ArrayList()
//                {{
//                    add( "dog" );
//                    add( "cat" );
//                    add( "dog" );
//                }} ) );
//
//    }

    //3
    @Test
    public void testAddPetEndpoint() {
        given()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "\t\"petId\":5,\n" +
                        "\t\"petType\":{\n" +
                        "\t\"petTypeId\":1,\n" +
                        "\t\"name\":\"dog\"}" +
                        "\n" +
                        "\t\"petName\":\"Timmy\",\n" +
                        "\t\"petAge\":5\n" +
                        "}")
                .when().post("/pets")
                .then()
                .assertThat()
                .statusCode(404);
//                .body(hasItem(
//                        allOf(
//                                hasEntry("petId","5"),
//                                hasEntry("petType","dog"),
//                                hasEntry("petName","Scrappy"),
//                                hasEntry("petAge","3")
//                        )
//                    )
//                );

    }

    //4
    @Test
    void testDeletePet() {
        given()
                .header("Content-Type", "application/json")
                .pathParam("petId", 1)
                .when().delete("/pets/{petId}")
                .then()
                .assertThat()
                .statusCode(404);
    }

}