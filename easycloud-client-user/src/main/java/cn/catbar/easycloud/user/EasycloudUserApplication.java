package cn.catbar.easycloud.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
// 必须把cn.catbar.easycloud.core.error依赖包含进去，全局异常处理才可以生效
@SpringBootApplication(scanBasePackages = {"cn.catbar.easycloud.user","cn.catbar.easycloud.core.error"})
@EnableFeignClients
public class EasycloudUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasycloudUserApplication.class, args);
    }

}
