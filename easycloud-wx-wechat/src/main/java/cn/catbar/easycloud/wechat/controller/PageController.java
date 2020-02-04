package cn.catbar.easycloud.wechat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 页面控制
 */
@Controller
public class PageController {

    @GetMapping("/")
    public String login(){
        return "index";
    }

    @GetMapping("/menu")
    public String menu(){
        return "wechatMenu";
    }
}
