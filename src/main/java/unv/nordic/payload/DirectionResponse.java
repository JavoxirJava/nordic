package unv.nordic.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class DirectionResponse {
    @JsonProperty("FULL_TIME")
    private List<EducationDirection> fullTime;

    @JsonProperty("PART_TIME")
    private List<EducationDirection> partTime;

    @JsonProperty("SPECIAL_PART_TIME")
    private List<EducationDirection> specialPartTime;
}
