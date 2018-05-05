package cn.jyuyang.timerTask;

import cn.jyuyang.MyQuartzJob;
import org.junit.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.io.IOException;

public class JobTest {
    @Test
    public void simpleTrigger() throws SchedulerException, IOException {
        JobDetail jobDetail = JobBuilder.newJob(MyQuartzJob.class).build();

        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule();

        simpleScheduleBuilder.withIntervalInSeconds(5);
        simpleScheduleBuilder.repeatForever();

        Trigger trigger = TriggerBuilder.newTrigger().withSchedule(simpleScheduleBuilder).build();
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();

        System.in.read();
    }

    @Test
    public void cronTrigger() throws SchedulerException, IOException {
        //1. 定义任务
        JobDetail jobDetail = JobBuilder.newJob(MyQuartzJob.class).build();
        //2. 定义触发的形式
        ScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/2 * * * * ? ");
        //3. 通过触发形式创建触发器
        Trigger trigger = TriggerBuilder.newTrigger().withSchedule(scheduleBuilder).build();
        //4. 创建任务调度者对象
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        //5. 调度任务
        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();

        System.in.read();
    }
}
