import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Marci on 2017.06.01..
 */
public class ThreadHandler {
    private List<TimerThread> timerThreads;

    public ThreadHandler() {
        timerThreads = new CopyOnWriteArrayList<>();
    }

    public void startTimer(String name){
        boolean match = false;
        for (TimerThread entry:timerThreads) {
            if (entry.getTimerName().equals(name)){
                match = true;
                if (entry.isRunning() == false) {
                    entry.run();
                }else {
                    System.out.println(name + " is already running");
                }
            }else {
                System.out.println("Wrong name");
            }

        }
        if (!match){
        TimerThread timerThread = new TimerThread(name,timerThreads.size()+1);
        timerThread.start();
        timerThreads.add(timerThread);}
    }

    public void checkTime(){
        for (TimerThread entry:timerThreads) {
            System.out.println(entry);
        }
    }

    public void checkTime(String name){
        for (TimerThread entry:timerThreads) {
            if (entry.getTimerName().equals(name)){
                System.out.println(entry);
                break;
            }else {
                System.out.println("Wrong name");
            }
        }
    }
    public void stopTimer(String name){
        for (TimerThread entry:timerThreads) {
            if (entry.getTimerName().equals(name)){
                if (entry.isRunning() == true) {
                    entry.interrupt();
                }else {
                    System.out.println(name+ " is already stopped");
                }
            }else {
                System.out.println("Wrong name");
            }

        }
}
}
