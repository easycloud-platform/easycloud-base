package cn.catbar.easycloud.wechat.api;

import cn.catbar.easycloud.core.AppResultBuilder;
import cn.catbar.easycloud.core.bean.AppResult;
import cn.catbar.easycloud.core.eum.ResultCode;
import cn.catbar.easycloud.wechat.service.WechatService;
import cn.catbar.easycloud.wechat.util.CheckoutUtil;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author Lee Qian
 * @Description 主要测试类
 * @Date 2018/11/28
 */
@RestController
@RequestMapping("/wechat")
@CrossOrigin //支持跨域
@Api(value="微信公众号接口",tags = "微信公众号接口",description="针对微信公众号服务")
public class WechatController {

    private static final Logger logger = LoggerFactory.getLogger(WechatController.class);

    @Resource
    private WechatService wechatService;

    @GetMapping("/getToken")
    @ApiOperation(value = "获取当前Token")
    public String getToken(){
        return wechatService.getToken();
    }

    /**
     * @Author wxt.leeq
     * @Description 响应微信发送的Token验证
     * @Date 2018/11/28
     */
    @GetMapping("/check")
    @ApiOperation(value = "验证微信Token")
    private void checkToken(HttpServletRequest request, HttpServletResponse response) {
        boolean isGet = request.getMethod().toLowerCase().equals("get");
        PrintWriter print;
        if (isGet) {
            // 微信加密签名
            String signature = request.getParameter("signature");
            // 时间戳
            String timestamp = request.getParameter("timestamp");
            // 随机数
            String nonce = request.getParameter("nonce");
            // 随机字符串
            String echostr = request.getParameter("echostr");
            // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
            if (signature != null && CheckoutUtil.checkSignature(signature, timestamp, nonce)) {
                try {
                    print = response.getWriter();
                    print.write(echostr);
                    print.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 获取菜单列表
     * @return
     */
    @GetMapping("/getMenu")
    @ApiOperation(value = "获取微信菜单列表")
    public JSONObject getMenu(){
        return wechatService.getMenu();
    }
    /**
     * @Author wxt.leeq
     * @Description 微信公众号创建菜单
     * @Date 2018/11/28
     */
    @PostMapping("/createMenu")
    @ApiOperation(value = "根据json创建微信菜单")
    public JSONObject createMenu(@RequestParam("menu")  String menu ,HttpServletRequest request){
        return wechatService.createMenu(menu);
    }

    /**
     * 微信公众号删除全部菜单
     */
    @GetMapping("/deleteMenu")
    @ApiOperation(value = "删除微信所有菜单")
    public JSONObject deleteMenu(){
        return wechatService.deleteMenu();
    }

    /**
     * 登录接口
     * @param code
     * @return
     */
    @GetMapping(value = "/getOpenId/{code}")
    @ApiOperation(value = "根据code获取用户openId")
    public AppResult<String> login(@PathVariable("code") String code) {
        // 通过code，获取openid
        String openId = wechatService.getOpenIdByCode(code);
        return AppResultBuilder.success(openId, ResultCode.SUCCESS);
    }



}

