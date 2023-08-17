package hello;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.jms.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/produce")
public class Producer {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Queue queue;

    //비디오 정보 객체를 받아서 JSON으로 변환 후 ActiveMq서버의 queue로 보냄
    @PostMapping("/message")
    public DeidetificationVideoInfo sendMessage(@RequestBody DeidetificationVideoInfo deidetificationVideoInfo) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String deidetificationVideoInfoAsJson = mapper.writeValueAsString(deidetificationVideoInfo);
            jmsTemplate.convertAndSend(queue,deidetificationVideoInfoAsJson);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return deidetificationVideoInfo;
    }
}
