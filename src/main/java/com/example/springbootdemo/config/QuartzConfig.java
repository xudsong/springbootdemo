package com.example.springbootdemo.config;

import com.example.springbootdemo.quartz.MyCronJob;
import com.example.springbootdemo.quartz.MyJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 定时任务配置
 */
@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail teatQuartzDetail(){
        return JobBuilder.newJob(MyJob.class)
                .withIdentity("testQuartz")
                .storeDurably().build();
    }
    @Bean
    public Trigger testSimpleQuartzTrigger(){
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(10)  //设置时间周期单位秒
                .repeatForever();
        return TriggerBuilder.newTrigger().forJob(teatQuartzDetail())
                .withIdentity("testQuartz")
                .withSchedule(scheduleBuilder)
                .build();
    }

    @Bean
    public JobDetail myCronJobDetail(){
        return JobBuilder.newJob(MyCronJob.class)
                .withIdentity("cronQuartz")
                .storeDurably().build();
    }

    @Bean
    public Trigger uploadTaskTrigger() {
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("*/5 * * * * ?");
        return TriggerBuilder.newTrigger().forJob(myCronJobDetail())
                .withIdentity("cronQuartz")
                .withSchedule(scheduleBuilder)
                .build();
    }


}
