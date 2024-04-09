package thread;

import java.util.Random;

class CommunicationChannel extends WorkerThread<Client> {

    private static final Long DEFAULT_PERFORM_DURATION = 5L;

    private final Long performDuration;

    public CommunicationChannel(Integer identifier, Buffer<Client> buffer, Long performDuration) {
        super(identifier, buffer);
        this.performDuration = performDuration;
    }

    public CommunicationChannel(Integer identifier, Buffer<Client> buffer) {
        super(identifier, buffer);
        this.performDuration = DEFAULT_PERFORM_DURATION;
    }

    @Override
    void perform() {
        while (true) {
            synchronized (buffer) {
                while (!this.performable()) {
                    try {
                        buffer.waitItems();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println("Thread Interrompida");
                    }
                }

                // Adiciona um cliente ao buffer
                Client client = this.generateClient();
                Boolean added = this.buffer.add(client);
                if (!added) {
                    System.out.println(client.getName() + " não pode ser atendido - Canal de Atendimento " + this.identifier);
                }

                // Pausa a thread pelo tempo determinado em taskPerformDuration()
                try {
                    Thread.sleep(this.taskPerformDuration());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Thread Interrompida");
                }
            }
        }
    }

    @Override
    protected Boolean performable() {
        return this.buffer.isQueueLimitUnreached();
    }

    @Override
    protected Long taskPerformDuration() {
        return performDuration;
    }

    private Client generateClient() {
        return new Client("Cliente - " + new Random().nextInt());
    }

}
