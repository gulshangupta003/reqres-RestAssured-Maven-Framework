package api.clients;

import api.models.CreateUserRequestBody;
import api.models.PartialUpdateUserRequestBody;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserApiClient {
    public Response get(int id) {
        return given()
                .contentType(ContentType.JSON)
                .header("x-api-key", "reqres-free-v1")
                .when()
                .get("/users/" + id);
    }

    public Response getAll() {
        return given()
                .accept(ContentType.JSON)
                .header("x-api-key", "reqres-free-v1")
                .when()
                .get("/users");
    }

    public Response getAll(int page) {
        return given()
                .accept(ContentType.JSON)
                .header("x-api-key", "reqres-free-v1")
                .queryParam("page", page)
                .when()
                .get("/users");
    }

    public Response create(CreateUserRequestBody body) {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("x-api-key", "reqres-free-v1")
                .body(body)
                .when()
                .post("/users");
    }

    public Response put(int id, CreateUserRequestBody body) {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("x-api-key", "reqres-free-v1")
                .body(body)
                .when()
                .put("/users/" + id);
    }

    public Response patch(int id, PartialUpdateUserRequestBody body) {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("x-api-key", "reqres-free-v1")
                .body(body)
                .when()
                .patch("/users/" + id);
    }
}
