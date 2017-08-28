import java.util.Timer;

public class Main {
    public static void main(String[] args){
        int bufferSize = 10;
        int sleepTime = 500;
        Buffer buffer_A = new Buffer(bufferSize);
        Buffer buffer_B = new Buffer(bufferSize);

        Buffer[] empty = new Buffer[0];
        Process send = new Process(new Buffer[]{buffer_A, buffer_B}, empty, sleepTime   );
        Process receive = new Process(empty, new Buffer[]{buffer_B, buffer_A}, sleepTime   );


        send.start();
        receive.start();

    }

}
