package thread;

public class App {

    private static final Integer ATTENDANTS_AVAILABLE = 5;
    private static final Integer COMMUNICATION_CHANNELS_AVAILABLE = 10;
    private static final Integer MAX_ATTENDING_LINE_LENGTH = 30;

    public static void main(String[] args){

        Buffer<Client> attendingLine = new Buffer<>(MAX_ATTENDING_LINE_LENGTH);

        ThreadPool<Client> communicationChannels = new CommunicationChannels(COMMUNICATION_CHANNELS_AVAILABLE, attendingLine);
        ThreadPool<Client> attendants = new Attendants(ATTENDANTS_AVAILABLE, attendingLine);

    }

}

