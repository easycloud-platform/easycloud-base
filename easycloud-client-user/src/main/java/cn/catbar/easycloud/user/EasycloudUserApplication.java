package cn.catbar.easycloud.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EasycloudUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasycloudUserApplication.class, args);
    }

}
