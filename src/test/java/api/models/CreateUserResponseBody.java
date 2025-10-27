package api.models;

import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

@Getter
public class CreateUserResponseBody {
    @Setter
    private int statusCode;
    private String createdAt;
    private String name;
    private String id;
    private String job;

    public void assertSuccessResponse(CreateUserRequestBody body) {
        Assert.assertEquals(this.getStatusCode(), 201);
        Assert.assertEquals(this.getName(), body.getName());
        Assert.assertEquals(this.getJob(), body.getJob());
        Assert.assertNotNull(this.getId());
    }
}