import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Buffer {

    /**
     * Provides lock for synchronization
     * NOTE: if we need to synchronize anything, synchronize on "lock"
     * lock.writeLock().lock();
     * lock.writeLock().unlock();
     */
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    private int[] buffer;
    private int bufferSize;
    private boolean initialized = false;
    private boolean bufferRead = false;

    public Buffer(int bufferSize) {
        this.bufferSize = bufferSize;
        this.buffer = new int[bufferSize];
        for(int i = 0; i < buffer.length; i++){
            buffer[i] = 0;
        }
    }


    public int read(int key) {
        int msg =0;
        lock.readLock().lock();
        try{
            msg = buffer[key];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Error:  Buffer array out of bounds");
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
            return msg;
        }
    }

    public void write(int key, int data) {
        lock.writeLock().lock();
        try{
            this.buffer[key] = data;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Error:  Buffer array out of bounds");
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }
    public int getBufferSize(){
        return bufferSize;
    }


    public boolean isInitialized(){
        boolean bool = false;
        lock.readLock().lock();
        try{
            bool= initialized;
        } finally {
            lock.readLock().unlock();
            return bool;
        }
    }
    public boolean isBufferRead(){
        boolean bool = false;
        lock.readLock().lock();
        try{
            bool= bufferRead;
        } finally {
            lock.readLock().unlock();
            return bool;
        }
    }

    public void setInitialized(boolean flag){
        // put a lock
        lock.writeLock().lock();
        try{
            initialized = flag;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void setBufferRead(boolean flag){
        // put a lock
        lock.writeLock().lock();
        try{
            bufferRead = flag;
        } finally {
            lock.writeLock().unlock();
        }
    }

}
