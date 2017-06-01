
import org.springframework.util.StopWatch;

/**
 * Created by Marci on 2017.06.01..
 */
public class TimerThread extends Thread {
   private StopWatch  stopWatch;
   private String timerName;
   private int threadId;
   private double result;
   private double stopTime;

    public String getTimerName() {
        return timerName;
    }

    public TimerThread(String timerName, int threadId) {
       this.timerName = timerName;
       this.threadId = threadId;
       stopWatch = new StopWatch();
   }
    @Override
    public void run() {
        stopWatch.start();
    }

    @Override
    public void interrupt() {
        stopWatch.stop();
        stopTime  =  stopWatch.getTotalTimeSeconds();
        result = 0;
        super.interrupt();
    }

    private int getTime(){
        if (stopWatch.isRunning()){
            stopWatch.stop();
            result  =  stopWatch.getTotalTimeSeconds();
            stopWatch.start();
        }
        else {
            result = stopTime;
        }

        return (int)result;
    }

    @Override
    public String toString() {
        return "Name: "+timerName+", " +
                "ThreadId: "+threadId+", " +
                "Seconds: " +getTime();
    }

    public Boolean isRunning(){
        return stopWatch.isRunning();
    }
}
