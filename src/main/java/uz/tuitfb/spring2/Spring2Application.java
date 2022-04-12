package uz.tuitfb.spring2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@SpringBootApplication
@EnableScheduling

public class Spring2Application {

    public static void main(String[] args) {
        SpringApplication.run(Spring2Application.class, args);
    }

//    @Scheduled(fixedRate = 1000L)
//    public void startRate() {
//        System.out.println("New Rate" + new Date());
//    }

//    @Scheduled(fixedDelay = 1000L)
//    public void startDaley() {
//        System.out.println("New Delay" + new Date());
//    }


    @Scheduled(cron = "0 28 10 * * *")
    public void startCron() {
        System.out.println("New Cron " + new Date());
    }
}
