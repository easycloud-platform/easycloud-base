package cn.catbar.easycloud.config.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EasycloudConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasycloudConfigClientApplication.class, args);
    }

}
