
public class Process extends AbstractThread {

    private boolean writeBool;
    private boolean readBool;
    private Buffer[] writeBuffers;
    private Buffer[] readBuffers;
    private int writeID = 0;
    private int readID = 0;
    private int currentWrite = 0;
    private int currentRead = 0;
    private int counter = 1;
    private int sleepTime;

    @Override
    public void run(){
//        while (isActive()) {
        while ((!Thread.currentThread().isInterrupted())) {
            if(writeBool){
                write(currentWrite, counter);
            }
            if(readBool && readBuffers[readID].isInitialized() ) {
                int msg = read(currentRead);
                System.out.println(msg);
            }


            counter++;
            next();
            sleep(sleepTime);

            // Stop Threads
            if(counter > 50){
                setActive(false);
                stop();
                Thread.currentThread().interrupt();
            }

        }

    }

    public Process(Buffer[] writeBuffers, Buffer[] readBuffers, int sleepTime) {
        this.sleepTime = sleepTime;
        if(writeBuffers.length > 0){
            this.writeBool = true;
            this.writeBuffers = writeBuffers;
        }
        if(readBuffers.length > 0){
            this.readBool = true;
            this.readBuffers = readBuffers;
        }
    }

    public void next(){
        if(writeBool){
            currentWrite = ++currentWrite % this.writeBuffers[writeID].getBufferSize();
            if(currentWrite == 0){
                writeBuffers[writeID].setInitialized(true);
                writeID = ++writeID % writeBuffers.length;

            }

        }

        if(readBool) {
            currentRead = ++currentRead % this.readBuffers[readID].getBufferSize();
            if(currentRead == 0)
                readID = ++readID % readBuffers.length;
        }

    }

    public void write(int key, int data){
        try{
            writeBuffers[writeID].write(key, data);
            writeBuffers[writeID].setBufferRead(false);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Error:  Process write array out of bounds");
            e.printStackTrace();
        }

    }

    public int read(int key){
        int msg = 0;
        try{
            msg = readBuffers[readID].read(key);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Error:  Process read array out of bounds");
            e.printStackTrace();
        }
        return msg;
    }
}
