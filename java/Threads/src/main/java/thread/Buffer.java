package thread;

import java.util.LinkedList;
import java.util.Queue;

class Buffer<T> {

    private static final Integer BUFFER_LIMIT = 20;

    private final Integer bufferLimit;
    private final Queue<T> items = new LinkedList<>();

    public Buffer(Integer bufferLimit) {
        this.bufferLimit = bufferLimit;
    }

    public Buffer() {
        this.bufferLimit = BUFFER_LIMIT;
    }

    public Boolean add(T newItem) {
        if (this.isQueueLimitUnreached()) {
            synchronized (items) {
                this.items.offer(newItem);
                this.items.notify();
            }
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public T poll() {
        return this.isQueueEmpty() ? null : this.items.poll();
    }

    public void waitItems() throws InterruptedException {
        synchronized (items) {
            this.items.wait();
        }
    }

    public Boolean isQueueLimitReached() {
        return this.items.size() > this.bufferLimit;
    }

    public Boolean isQueueLimitUnreached() {
        return this.items.size() <= this.bufferLimit;
    }

    public Boolean isQueueEmpty() {
        return this.items.isEmpty();
    }

    public Boolean itemOnQueue() {
        return !this.items.isEmpty();
    }

}
