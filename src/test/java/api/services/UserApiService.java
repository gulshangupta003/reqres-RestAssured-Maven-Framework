package api.services;

import api.clients.UserApiClient;
import api.models.CreateUserRequestBody;
import api.models.CreateUserResponseBody;
import api.models.GetAllUsersResponseBody;
import api.models.GetSingleUserResponseBody;
import io.restassured.response.Response;

public class UserApiService {
    private final UserApiClient userApiClient;

    public UserApiService(UserApiClient userApiClient) {
        this.userApiClient = userApiClient;
    }

    public CreateUserResponseBody createUser(CreateUserRequestBody body) {
        Response response = userApiClient.create(body);

        response.then()
                .log().body();

        CreateUserResponseBody createUserResponseBody = response.as(CreateUserResponseBody.class);
        createUserResponseBody.setStatusCode(response.getStatusCode());

        return createUserResponseBody;
    }

    public GetSingleUserResponseBody getSingleUser(int id) {
        Response response = userApiClient.get(id);

        response.then()
                .log().body();

        GetSingleUserResponseBody getSingleUserResponseBody = response.as(GetSingleUserResponseBody.class);
        getSingleUserResponseBody.setStatusCode(response.getStatusCode());

        return getSingleUserResponseBody;
    }

    public GetAllUsersResponseBody getAllUsers() {
        Response response = userApiClient.getAll();

        response.then()
                .log().body();

        GetAllUsersResponseBody getAllUsersResponseBody = response.as(GetAllUsersResponseBody.class);
        getAllUsersResponseBody.setStatusCode(response.getStatusCode());

        return getAllUsersResponseBody;
    }

    public GetAllUsersResponseBody getAllUsers(int page) {
        Response response = userApiClient.getAll(page);

        response.then()
                .log().body();

        GetAllUsersResponseBody getAllUsersResponseBody = response.as(GetAllUsersResponseBody.class);
        getAllUsersResponseBody.setStatusCode(response.getStatusCode());

        return getAllUsersResponseBody;
    }
}
