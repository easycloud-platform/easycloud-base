package cn.catbar.easycloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//开启作为配置服务器的支持
@EnableConfigServer
//开启作为Eureka Server的客户端的支持
@EnableEurekaClient
public class EasycloudConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasycloudConfigApplication.class, args);
    }

}
