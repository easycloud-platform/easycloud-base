package cn.catbar.easycloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//开启作为配置服务器的支持
@EnableEurekaClient
@EnableConfigServer
public class EasycloudConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasycloudConfigServerApplication.class, args);
    }

}
