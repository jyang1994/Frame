package cn.jyuyang.timerTask;

import cn.jyuyang.SendWeixin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-quartz.xml","classpath:spring-datasourece.xml"})
public class QuartzTest {

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    @Test
    public void run() throws IOException {
        System.out.println("Spring start....");

        System.in.read();
    }

    @Test
    public void addJob() throws SchedulerException, IOException {
        //1.jodDetail
        JobDataMap dataMap = new JobDataMap();
        dataMap.put("weixin","xiaoming");

        JobDetail jobDetail = JobBuilder.newJob(SendWeixin.class)
                //!定义任务的唯一性（名称+组名）
                .withIdentity("weixin:xiaoming","sendWeixin")
                .setJobData(dataMap)
                .build();

        String cron = "0 15 15 7 5 ? 2018";
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
        Trigger trigger = TriggerBuilder.newTrigger().withSchedule(cronScheduleBuilder).build();

        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();

        System.in.read();

    }

    @Test
    public void deleteTask() throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        scheduler.deleteJob(new JobKey("weixin:xiaoming","sendWeixin"));
    }

}