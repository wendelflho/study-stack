package thread;

class CommunicationChannels extends ThreadPool<Client> {

    public CommunicationChannels(Integer poolSize, Buffer<Client> buffer) {
        super(poolSize, buffer);
    }

    @Override
    WorkerThread<Client> initializeThread(Integer identifier) {
        return new CommunicationChannel(identifier, this.buffer);
    }


}
