package thread;

import java.util.Optional;

class Attendant extends WorkerThread<Client> {

    private static final Long DEFAULT_PERFORM_DURATION = 3L;

    private final Long performDuration;

    public Attendant(Integer identifier, Buffer<Client> buffer, Long performDuration) {
        super(identifier, buffer);
        this.performDuration = performDuration;
    }

    public Attendant(Integer identifier, Buffer<Client> buffer) {
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
                try {
                    Thread.sleep(this.taskPerformDuration());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Thread Interrompida");
                }
                Optional.ofNullable(this.buffer.poll())
                        .ifPresent(this::attend);
            }
        }
    }

    @Override
    protected Boolean performable() {
        return this.buffer.itemOnQueue();
    }

    @Override
    protected Long taskPerformDuration() {
        return performDuration;
    }

    private void attend(Client client) {
        System.out.println("Atendente " + identifier + " atendendo - " + client.getName());
    }

}
