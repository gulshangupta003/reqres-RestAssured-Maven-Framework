package api.models;

import api.models.base.BaseResponseBody;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class PartialUpdateUserRequestBody extends BaseResponseBody {
    private String name;
    private String job;
}