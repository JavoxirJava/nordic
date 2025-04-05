package unv.nordic.payload;

import lombok.Data;

@Data
public class FileSize {
    private Long bytes;
    private String kb;
    private String mb;
    private String gb;
}
