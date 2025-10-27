package api.tests;

import api.clients.UserApiClient;
import api.models.CreateUserRequestBody;
import api.models.CreateUserResponseBody;
import api.models.GetAllUsersResponseBody;
import api.models.GetSingleUserResponseBody;
import api.services.UserApiService;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserApiTest extends BaseTest {
    private UserApiService userApiService;

    @BeforeMethod
    public void beforeClass() {
        UserApiClient userApiClient = new UserApiClient();
        userApiService = new UserApiService(userApiClient);
    }

    @Test
    public void createUser() {
        // Arrange
        CreateUserRequestBody requestBody = CreateUserRequestBody.builder()
                .name("morpheus")
                .job("leader")
                .build();

        // Act
        CreateUserResponseBody responseBody = userApiService.createUser(requestBody);

        // Assert
        responseBody.assertSuccessResponse(requestBody);
    }

    @Test
    public void shouldGetSingleUser() {
        // Arrange
        CreateUserRequestBody createUserRequestBody = CreateUserRequestBody.builder()
                .name("morpheus")
                .job("leader")
                .build();
        CreateUserResponseBody createUserResponseBody = userApiService.createUser(createUserRequestBody);
        int userId = Integer.parseInt(createUserResponseBody.getId());

        // Act
        GetSingleUserResponseBody responseBody = userApiService.getSingleUser(userId);

        // Assert
        Assert.assertEquals(responseBody.getStatusCode(), 200);
    }

    @Test
    public void shouldGetAllUsers() {
        // Arrange

        // Act
        GetAllUsersResponseBody getAllUsersResponseBody = userApiService.getAllUsers();

        // Assert
        Assert.assertEquals(getAllUsersResponseBody.getStatusCode(), 200);
        Assert.assertEquals(getAllUsersResponseBody.getPage(), 1);
    }

    @Test
    public void shouldGetAllUsersWithPageParameter() {
        // Arrange
        int page = 2;

        // Act
        GetAllUsersResponseBody getAllUsersResponseBody = userApiService.getAllUsers(page);

        // Assert
        Assert.assertEquals(getAllUsersResponseBody.getStatusCode(), 200);
        Assert.assertEquals(getAllUsersResponseBody.getPage(), page);
    }
}
