package api.models;

import api.models.base.BaseResponseBody;
import lombok.Getter;

import static org.testng.Assert.*;

@Getter
public class CreateUserResponseBody extends BaseResponseBody {
    private String name;
    private String job;
    private String id;
    private String createdAt;

    public void assertSuccessResponse(CreateUserRequestBody body) {
        assertEquals(this.getStatusCode(), 201);
        assertEquals(this.getName(), body.getName());
        assertEquals(this.getJob(), body.getJob());
        assertNotNull(this.getId());
    }
}