package cn.jyuyang.timerTask;


import cn.jyuyang.MyTimerTask;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.Timer;

public class TimerTest {

    @Test
  public void test() throws IOException {
      Timer timer = new Timer();
    //  timer.schedule(new MyTimerTask(),0,1000);
     timer.schedule(new MyTimerTask(),new Date(),1000);
      System.in.read();
  }

}
