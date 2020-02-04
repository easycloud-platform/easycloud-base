package cn.catbar.easycloud.wechat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EasycloudWechatApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasycloudWechatApplication.class, args);
    }

}
