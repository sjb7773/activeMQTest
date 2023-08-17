package hello;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.jms.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consume")
public class NewConsumer {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Queue queue;

    //Queue에서 Json을 받아서 JmsTemplate을 이용해 비디오 정보 객체 클래스로 변환
    @GetMapping("/message")
    public DeidetificationVideoInfo consumeMessage() {
        DeidetificationVideoInfo deidetificationVideoInfo = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonMessage = (String) jmsTemplate.receiveAndConvert(queue);
            deidetificationVideoInfo = mapper.readValue(jsonMessage, DeidetificationVideoInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deidetificationVideoInfo;
    }
}
