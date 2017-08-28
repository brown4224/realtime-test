/**
 * Created by sean on 8/23/17.
 */
//public class RealTime {
//
//    /*  Returns an instance of the classes  */
//    private static RealTime instance = new RealTime();
//
//    /*  Variables  */
//    private int bufferSize = 10;
//
//    private Buffer bufferA = new Buffer(bufferSize);
//
//    private Buffer bufferB = new Buffer(bufferSize);
//
//    private Process sender = new Process(new Buffer[]{bufferA, bufferB}, null);
//
//    private Process reciever = new Process(null, new Buffer[]{bufferB, bufferA});
//
//
//    /*  Constructor  */
//    public RealTime() {
//    }
//
//    // Getters and Setters
//    public static  RealTime getInstance(){
//        return instance;
//    }
//
//    public Buffer getBufferA() {
//        return bufferA;
//    }
//
//    public void setBufferA(Buffer bufferA) {
//        this.bufferA = bufferA;
//    }
//
//    public Buffer getBufferB() {
//        return bufferB;
//    }
//
//    public void setBufferB(Buffer bufferB) {
//        this.bufferB = bufferB;
//    }
//
//    public Process getSender() {
//        return sender;
//    }
//
//    public void setSender(Process sender) {
//        this.sender = sender;
//    }
//
//    public Process getReciever() {
//        return reciever;
//    }
//
//    public void setReciever(Process reciever) {
//        this.reciever = reciever;
//    }
//}
