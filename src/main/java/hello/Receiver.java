package hello;



//Receiver -> Message-dricen POJO
//@Component
public class Receiver {

//    @JmsListener(destination = "mailbox", containerFactory = "myFactory")
    public void receiveMessage(Email email) {
        System.out.println("Received email = " + email);
    }
}
