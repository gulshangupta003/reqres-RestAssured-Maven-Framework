package api.models;

import api.models.base.BaseResponseBody;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class GetAllUsersResponseBody extends BaseResponseBody {
    private int page;
    @JsonProperty("per_page")
    private int perPage;
    private int total;
    @JsonProperty("total_pages")
    private int totalPages;
    private List<Data> data;
    private Support support;
    @JsonProperty("_meta")
    private Meta meta;

    @Getter
    public static class Data {
        private int id;
        private String email;
        @JsonProperty("first_name")
        private String firstName;
        @JsonProperty("last_name")
        private String lastName;
        private String avatar;
    }

    @Getter
    public static class Support {
        private String url;
        private String text;
    }

    @Getter
    public static class Meta {
        @JsonProperty("powered_by")
        private String poweredBy;
        @JsonProperty("upgrade_url")
        private String upgradeUrl;
        @JsonProperty("docs_url")
        private String docsUrl;
        @JsonProperty("template_gallery")
        private String templateGallery;
        private String message;
        private List<String> features;
        @JsonProperty("upgrade_cta")
        private String upgradeCta;
    }
}