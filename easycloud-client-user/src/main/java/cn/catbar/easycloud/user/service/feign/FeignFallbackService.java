package cn.catbar.easycloud.user.service.feign;

import cn.catbar.easycloud.user.service.feign.interfaces.ConfigInterface;
import org.springframework.stereotype.Service;

//远程调用失败回调类FeignFallbackService，要实现对应的FeignClient实现对应的方法:
@Service
public class FeignFallbackService implements ConfigInterface {

    @Override
    public String gateway() {
        return "error";
    }
}
