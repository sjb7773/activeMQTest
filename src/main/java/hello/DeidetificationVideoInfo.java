package hello;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class DeidetificationVideoInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    private String inputPath;
    private String outputPath;
}
