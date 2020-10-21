package com.ecom.transportservice.jobs;


import com.ecom.transportservice.service.RestService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;


@DisallowConcurrentExecution
public class RestCallServiceJob implements Job {



    @Autowired
    RestService restService;

    @Override
    public void execute(JobExecutionContext context){
        //log.info("Job ** {} ** starting @ {}", context.getJobDetail().getKey().getName(), context.getFireTime());
        try {
            restService.getRestJson();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //log.info("Job ** {} ** completed.  Next job scheduled @ {}", context.getJobDetail().getKey().getName(), context.getNextFireTime());


    }
}
