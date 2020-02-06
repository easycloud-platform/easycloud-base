package cn.catbar.easycloud.user.service.feign.interfaces;

import cn.catbar.easycloud.user.service.feign.FeignFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value="config-client",fallback = FeignFallbackService.class)
//这里是要远程调用的服务的名称，即你要调用服务的spring.application.name
//fallback是远程调用失败回调的方法
public interface ConfigInterface {

    @GetMapping(value = "/gateway")
    String gateway();
}
