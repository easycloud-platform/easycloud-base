package cn.catbar.easycloud.wechat.service;

import cn.catbar.easycloud.utils.HttpClientUtils;
import cn.catbar.easycloud.wechat.bean.GetPageOpenidBean;
import cn.catbar.easycloud.wechat.bean.Token;
import cn.catbar.easycloud.wechat.contants.WxConstants;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


/**
 * 微信公众号工具类
 * 例如：获取Token，发送模板消息，根据code获取openId等
 */
@Service
public class WechatService {

    private static final Logger logger = LoggerFactory.getLogger(WechatService.class);
    public Token token = new Token();
    /**
     * 获得Token
     */
    public  String getToken() {
        Token accessTocken = getToken( System.currentTimeMillis() / 1000);
        return accessTocken.getAccessToken();
    }
    /**
     * 获取access_token
     */
    public  Token getToken( long currentTime) {
        // 一天有获取2000次的限制 ,设置半个小时获取一次AccessToken防止超出请求限制
        long liveTime = token.getExpiresIn()-(currentTime-token.getAddTime());
        if (!"".equals(token.getAccessToken())&&token.getAccessToken()!=null){
            if (currentTime-token.getAddTime()<token.getExpiresIn()){
                logger.info("缓存中获取Token成功："+token.getAccessToken()+",剩余有效期"+liveTime+"秒。");
                return token;
            }
        }
        try {
            // 调用接口获取token
            String requestUrl = WxConstants.BASE_TOKEN_URL + "grant_type=" + WxConstants.GRANT_TYPE + "&appid=" + WxConstants.APP_ID + "&secret=" + WxConstants.SECRET;
            String result = HttpClientUtils.doGet(requestUrl);
            logger.info("请求获取Token结果：" + result);
            JSONObject jsonObject = JSON.parseObject(result);
            // 如果请求成功
            if (null != jsonObject) {
                if(jsonObject.containsKey("access_token")){
                    token.setAccessToken(jsonObject.getString("access_token"));
                    token.setExpiresIn(jsonObject.getIntValue("expires_in")/2);
                    token.setAddTime(currentTime);
                }else{
                    token.setAccessToken("");
                }
            }else{
                token.setAccessToken("");
            }
        }catch (Exception e){
            logger.error("获取Token异常:"+e.toString());
        }
        return token;
    }

    /**
     * 发送模板消息
     */
    public  JSONObject sendModelMessage(String jsonMsg) {
        JSONObject jsonObject =null;
        try {
            logger.info("消息内容："+ jsonMsg);
            // 拼接请求地址
            String requestUrl = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
            requestUrl = requestUrl.replace("ACCESS_TOKEN", getToken());
            // 打开和URL之间的连接
            String result = HttpClientUtils.doPostJson(requestUrl,jsonMsg);
            // 发送客服消息
            jsonObject = JSON.parseObject(result);

            if (null != jsonObject) {
                int errorCode = jsonObject.getInteger("errcode");
                String errorMsg = jsonObject.getString("errmsg");
                if (0 == errorCode) {
                    logger.info("模板消息发送成功 ,errorCode:"+ errorCode+",errorMsg:"+ errorMsg);
                } else {
                    logger.info("模板消息发送失败 ,errorCode:"+ errorCode+",errorMsg:"+ errorMsg);
                }
            }
        } catch (Exception e){
            logger.error("模板消息发送失败："+e.toString());
        }
        return jsonObject;
    }

    /**
     * 根据openID获取用户个人信息
     * @param id
     * @return
     */
    public  JSONObject userInfo(String id) {
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
        requestUrl = requestUrl.replace("ACCESS_TOKEN", getToken());
        requestUrl = requestUrl.replace("OPENID",id);

        // 打开和URL之间的连接
        String result = HttpClientUtils.doGet(requestUrl);
        return JSONObject.parseObject(result);
    }



    /**
     * 通过Code获取openID
     */
    public static String getOpenIdByCode(String code) {
        GetPageOpenidBean bean = null;
        String json = "";
        try {
            String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + WxConstants.APP_ID + "&secret=" + WxConstants.SECRET + "&code=" + code + "&grant_type=authorization_code";
            json = HttpClientUtils.doGet(url);
            logger.info(url,json);
            ObjectMapper mapper = new ObjectMapper();
            bean = (GetPageOpenidBean) mapper.readValue(json, GetPageOpenidBean.class);
            logger.info("获取用户openId："+bean.toString());
            return bean.getOpenid();
        } catch (Exception e) {
            logger.error("根据code获取accesstoken和openid失败入参,code=" + code);
            logger.error(e.toString());
            e.printStackTrace();
        }
        return null;
    }

    public  JSONObject createMenu(String jsonMsg) {
        String url = WxConstants.CREATE_MENU_URL.replace("ACCESS_TOKEN", getToken());
        int result = 0;
        String json = HttpClientUtils.doPostJson(url, jsonMsg);
        JSONObject jsonObject = JSON.parseObject(json);
        return jsonObject;
    }

    public  JSONObject deleteMenu() {
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
        requestUrl = requestUrl.replace("ACCESS_TOKEN", getToken());
        // 打开和URL之间的连接
        String result = HttpClientUtils.doGet(requestUrl);
        return JSONObject.parseObject(result);
    }

    public  JSONObject getMenu() {
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
        requestUrl = requestUrl.replace("ACCESS_TOKEN", getToken());
        // 打开和URL之间的连接
        String result = HttpClientUtils.doGet(requestUrl);
        return JSONObject.parseObject(result);
    }

}
