package cn.jyuyang.config;

import cn.jyuyang.job.MyJob;
import org.quartz.JobDataMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.sql.DataSource;


@Configuration
public class QuartzConfig {

    @Bean
    public JobDetailFactoryBean detailFactoryBean(){
        JobDetailFactoryBean bean = new JobDetailFactoryBean();
        bean.setDurability(true);
        bean.setJobClass(MyJob.class);

        JobDataMap dataMap = new JobDataMap();
        dataMap.put("message","niHao");

        bean.setJobDataAsMap(dataMap);

        return bean;
    }


    @Bean
    public CronTriggerFactoryBean cronTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean) {
        CronTriggerFactoryBean triggerFactoryBean = new CronTriggerFactoryBean();
        //配置jobDetail
        triggerFactoryBean.setJobDetail(jobDetailFactoryBean.getObject());
        //配置Cron表达式
        triggerFactoryBean.setCronExpression("0/2 * * * * ?");
        return triggerFactoryBean;
    }


    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(CronTriggerFactoryBean cronTriggerFactoryBean,
                                                     DataSource dataSource,
                                                     DataSourceTransactionManager transactionManager) {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        //设置触发器
        schedulerFactoryBean.setTriggers(cronTriggerFactoryBean.getObject());
        //设置数据库练级池
        schedulerFactoryBean.setDataSource(dataSource);
        //设置事务管理器
        schedulerFactoryBean.setTransactionManager(transactionManager);
        //配置文件的位置
        schedulerFactoryBean.setConfigLocation(new ClassPathResource("quartz.properties"));
        //覆盖现有的任务
        schedulerFactoryBean.setOverwriteExistingJobs(true);
        return schedulerFactoryBean;
    }
}
