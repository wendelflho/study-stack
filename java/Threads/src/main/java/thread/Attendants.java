package thread;

class Attendants extends ThreadPool<Client> {

    public Attendants(Integer poolSize, Buffer<Client> buffer) {
        super(poolSize, buffer);
    }

    @Override
    public WorkerThread<Client> initializeThread(Integer identifier) {
        return new Attendant(identifier, this.buffer);
    }
}
