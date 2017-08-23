
public class Process extends AbstractThread {

    private int current;
    private int totalBuffers;
    public Process(int initialBuffer, int totalBuffers) {
        this.current = initialBuffer;
        this.totalBuffers = totalBuffers;
    }

    @Override
    private void run(){
        //  Driver of thread

        this.sleep(1000);
    }




    public void nextBuffer(){
        current = ++current % totalBuffers;
    }

    public void write(){
        // Write to buffer
    }

    public String read(){
        // return a string
    }
}
