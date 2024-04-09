package thread;

abstract class WorkerThread<T> extends Thread {

    protected final Integer identifier;
    protected final Buffer<T> buffer;

    protected WorkerThread(Integer identifier, Buffer<T> buffer) {
        this.identifier = identifier;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        this.perform();
    }

    abstract void perform();

    abstract Boolean performable();

    abstract Long taskPerformDuration();

}
