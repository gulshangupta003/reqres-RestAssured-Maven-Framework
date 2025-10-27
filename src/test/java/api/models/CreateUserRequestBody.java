package api.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class CreateUserRequestBody {
    private String name;
    private String job;
}