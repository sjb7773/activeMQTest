package springDocumnetationVer;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private String studentId;
    private String name;
    private String rollNumber;


}
