package cn.jyuyang;

import java.util.TimerTask;

public class MyTimerTask extends TimerTask{

    /**
     * The action to be performed by this timer task.
     */
    public void run() {
        System.out.println("hello.task");
    }
}
