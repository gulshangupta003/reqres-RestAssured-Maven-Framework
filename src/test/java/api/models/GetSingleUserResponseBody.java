package api.models;

import api.models.base.BaseResponseBody;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class GetSingleUserResponseBody extends BaseResponseBody {
    private Data data;
    @JsonProperty("_meta")
    private Meta meta;
    private Support support;

    @Getter
    public class Data {
        @JsonProperty("last_name")
        private String lastName;
        private int id;
        private String avatar;
        @JsonProperty("first_name")
        private String firstName;
        private String email;
    }

    @Getter
    public static class Meta {
        @JsonProperty("docs_url")
        private String docsUrl;
        private List<String> features;
        @JsonProperty("powered_by")
        private String poweredBy;
        @JsonProperty("template_gallery")
        private String templateGallery;
        private String message;
        @JsonProperty("upgrade_url")
        private String upgradeUrl;
        @JsonProperty("upgrade_cta")
        private String upgradeCta;
    }

    @Getter
    public class Support {
        private String text;
        private String url;
    }
}