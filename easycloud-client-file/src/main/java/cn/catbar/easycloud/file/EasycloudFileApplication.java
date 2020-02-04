package cn.catbar.easycloud.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EasycloudFileApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasycloudFileApplication.class, args);
    }

}
