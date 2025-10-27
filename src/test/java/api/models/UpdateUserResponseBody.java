package api.models;

import api.models.base.BaseResponseBody;
import lombok.Getter;
import lombok.Setter;

@Getter
public class UpdateUserResponseBody extends BaseResponseBody {
    private String name;
    private String job;
    private String updatedAt;
}