package com.ecom.transportservice.config;

import com.ecom.transportservice.jobs.RestCallServiceJob;
import org.quartz.JobDetail;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;

@Configuration
public class QuartzSubmitJobs {
   // private static final String CRON_EVERY_TWENTY_FOUR_MINUTES = "0 0 */24 ? * * *";

    private static final String CRON_EVERY_TWENTY_FOUR_MINUTES = "0 0/5 * ? * * *";


    @Bean(name = "restCallService")
    public JobDetailFactoryBean jobRestCall(){
        return QuartzConfig.createJobDetail(RestCallServiceJob.class, "Call Rest API");
    }

    public CronTriggerFactoryBean triggerRestCall(@Qualifier("restCallService") JobDetail jobDetail){
        return QuartzConfig.createCronTrigger(jobDetail, CRON_EVERY_TWENTY_FOUR_MINUTES, "Call rest Trigger");
    }
}
