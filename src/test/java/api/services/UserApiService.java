package api.services;

import api.clients.UserApiClient;
import api.models.*;
import api.models.base.BaseResponseBody;
import io.restassured.response.Response;

public class UserApiService {
    private final UserApiClient userApiClient;

    public UserApiService(UserApiClient userApiClient) {
        this.userApiClient = userApiClient;
    }

    public GetSingleUserResponseBody getSingleUser(int id) {
        Response response = userApiClient.get(id);

        response.then().log().body();

        return extractResponseBody(response, GetSingleUserResponseBody.class);
    }

    public GetAllUsersResponseBody getAllUsers() {
        Response response = userApiClient.getAll();
        response.then().log().body();

        return extractResponseBody(response, GetAllUsersResponseBody.class);
    }

    public GetAllUsersResponseBody getAllUsers(int page) {
        Response response = userApiClient.getAll(page);
        response.then().log().body();

        return extractResponseBody(response, GetAllUsersResponseBody.class);
    }

    public CreateUserResponseBody createUser(CreateUserRequestBody body) {
        Response response = userApiClient.create(body);
        response.then().log().body();

        return extractResponseBody(response, CreateUserResponseBody.class);
    }

    public UpdateUserResponseBody updateUser(int id, CreateUserRequestBody body) {
        Response response = userApiClient.put(id, body);
        response.then().log().body();

        return extractResponseBody(response, UpdateUserResponseBody.class);
    }

    private <T extends BaseResponseBody> T extractResponseBody(Response response, Class<T> responseClass) {
        T responseBody = response.as(responseClass);
        responseBody.setStatusCode(response.statusCode());
        responseBody.setResponseTime(response.time());

        return responseBody;
    }
}
