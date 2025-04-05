package unv.nordic.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class FileResource {
    private String id;

    @JsonProperty("file_name")
    private String fileName;

    @JsonProperty("file_path")
    private String filePath;

    @JsonProperty("is_image")
    private Boolean isImage;

    @JsonProperty("is_audio")
    private Boolean isAudio;

    private Integer duration;

    @JsonProperty("content_type")
    private String contentType;

    private String extension;

    @JsonProperty("file_size")
    private FileSize fileSize;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
