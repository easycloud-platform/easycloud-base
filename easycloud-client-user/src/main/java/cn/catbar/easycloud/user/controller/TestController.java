package cn.catbar.easycloud.user.controller;

import cn.catbar.easycloud.user.service.feign.interfaces.ConfigInterface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private ConfigInterface configInterface;

    @GetMapping(value = "/test")
    public String home(){
         return configInterface.gateway();
    }
}
