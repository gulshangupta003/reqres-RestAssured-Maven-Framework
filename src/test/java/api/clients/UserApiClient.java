package api.clients;

import api.config.ConfigManager;
import api.models.CreateUserRequestBody;
import api.models.PartialUpdateUserRequestBody;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserApiClient {
    public Response get(int id) {
        return given()
                .contentType(ContentType.JSON)
                .header("x-api-key", ConfigManager.getApiKey())
                .when()
                .get(ConfigManager.getUsersEndpoint() + "/" + id);
    }

    public Response getAll() {
        return given()
                .accept(ContentType.JSON)
                .header("x-api-key", ConfigManager.getApiKey())
                .when()
                .get(ConfigManager.getUsersEndpoint());
    }

    public Response getAll(int page) {
        return given()
                .accept(ContentType.JSON)
                .header("x-api-key", ConfigManager.getApiKey())
                .queryParam("page", page)
                .when()
                .get(ConfigManager.getUsersEndpoint());
    }

    public Response create(CreateUserRequestBody body) {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("x-api-key", ConfigManager.getApiKey())
                .body(body)
                .when()
                .post(ConfigManager.getUsersEndpoint());
    }

    public Response put(int id, CreateUserRequestBody body) {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("x-api-key", ConfigManager.getApiKey())
                .body(body)
                .when()
                .put(ConfigManager.getUsersEndpoint() + "/" + id);
    }

    public Response patch(int id, PartialUpdateUserRequestBody body) {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("x-api-key", ConfigManager.getApiKey())
                .body(body)
                .when()
                .patch(ConfigManager.getUsersEndpoint() + "/" + id);
    }

    public Response delete(int id) {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("x-api-key", ConfigManager.getApiKey())
                .when()
                .delete(ConfigManager.getUsersEndpoint() + "/" + id);
    }
}
