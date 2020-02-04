package cn.catbar.easycloud.servermanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EasycloudServerManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasycloudServerManagerApplication.class, args);
    }

}
