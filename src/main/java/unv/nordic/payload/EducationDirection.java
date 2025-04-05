package unv.nordic.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class EducationDirection {
    private String id;

    @JsonProperty("edu_direction_id")
    private String eduDirectionId;

    private String name;
    private int duration;
    private int price;

    @JsonProperty("field_code")
    private String fieldCode;

    @JsonProperty("field_lang")
    private String fieldLang;

    @JsonProperty("image_id")
    private String imageId;
    private FileResource image;

    @JsonProperty("curriculum_id")
    private String curriculumId;
    private FileResource curriculum;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
