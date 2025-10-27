package api.models.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponseBody {
    @JsonIgnore
    private int statusCode;
    @JsonIgnore
    private long responseTime;
}
