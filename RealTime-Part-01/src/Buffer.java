import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by workstation on 8/23/17.
 */
public class Buffer {

    /**
     * Provides lock for synchronization
     * NOTE: if we need to synchronize anything, synchronize on "lock"
     * lock.writeLock().lock();
     * lock.writeLock().unlock();
     */
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private int[] buffer = new int[10];

    public Buffer() {
        for(int i = 0; i < buffer.length; i++){
            buffer[i] = 0;
        }
    }
}
