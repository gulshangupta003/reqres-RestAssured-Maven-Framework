package api.tests;

import api.clients.UserApiClient;
import api.models.*;
import api.services.UserApiService;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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

    @Test(enabled = false)
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

    @Test
    public void shouldUpdateUserData() {
        // Arrange
        int userId = 2;
        CreateUserRequestBody requestBody = CreateUserRequestBody.builder()
                .name("rahul")
                .job("enterprises")
                .build();

        // Act
        UpdateUserResponseBody responseBody = userApiService.updateUser(userId, requestBody);

        // Assert
        Assert.assertEquals(responseBody.getStatusCode(), 200);
        Assert.assertEquals(responseBody.getName(), requestBody.getName());
        Assert.assertEquals(responseBody.getJob(), requestBody.getJob());
    }

    @Test(dataProvider = "partialUpdateCases")
    public void testPartialUpdate(String name, String job) {
        // Arrange
        int userId = 2;
        PartialUpdateUserRequestBody requestBody = new PartialUpdateUserRequestBody(name, job);

        // Act
        UpdateUserResponseBody responseBody = userApiService.partiallyUpdateUser(userId, requestBody);

        // Assert
        Assert.assertEquals(responseBody.getStatusCode(), 200);
        Assert.assertEquals(responseBody.getName(), requestBody.getName());
        Assert.assertEquals(responseBody.getJob(), requestBody.getJob());
        Assert.assertNotNull(responseBody.getUpdatedAt());
    }

    @DataProvider(name = "partialUpdateCases")
    private Object[][] partialUpdateCases() {
        return new Object[][]{
                {"John Doe Updated", null},
                {null, "admin"},
                {"John Doe Updated", "admin"}
        };
    }

    @Test
    public void testDeleteUser() {
        // Arrange
        int userId = 2;

        // Act
        DeleteUserResponseBody responseBody = userApiService.deleteUser(userId);

        // Assert
        Assert.assertEquals(responseBody.getStatusCode(), 204);
    }
}
