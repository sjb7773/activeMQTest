package hello;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Email {

    //Spring 은 모든 POJO에게 메세지를 publish할 수단을 제공
    private String to;
    private String body;


}
