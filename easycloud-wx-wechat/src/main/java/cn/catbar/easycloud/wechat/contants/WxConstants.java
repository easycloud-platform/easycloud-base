package cn.catbar.easycloud.wechat.contants;

/**
 * 微信参数常量
 */
public class WxConstants {
    /**微信公众号开发配置 start*/
    // 与接口配置信息中的Token要一致
//    public static final String TOKEN = "zhtw";
//    //自己的AppID
//    public static final String APP_ID = "wxbd74ccfc5d21733e";
//    //自己的AppSecret
//    public static final String SECRET = "7dda91d80dcf4d0b1690e35751dfa0b9";

    /**微信公众号开发配置 end*/


    /*乐山医院公众号信息 start*/
    public static final String TOKEN = "lsszyycom";
    //自己的AppID
    public static final String APP_ID = "wxda07efa0e8ea9664";
    //自己的AppSecret
    public static final String SECRET = "240ba5d1e0b6e7ee69345f1d8a900cce";
    /*乐山医院公众号信息 end*/

    /*宁南县医院公众号信息 start*/
//    public static final String TOKEN = "nnxzyyy";
//    //自己的AppID
//    public static final String APP_ID = "wxc4434b769cd1a619";
//    //自己的AppSecret
//    public static final String SECRET = "4ec6f05ff4eff239b820d59f903f1073";
    /*宁南县医院公众号信息 end*/

    /*我的公众号配置 start*/
//    public static final String TOKEN = "wx";
//    //自己的AppID
//    public static final String APP_ID = "wx9fe98b0c04e3bb93";
//    //自己的AppSecret
//    public static final String SECRET = "f6749a1df9b603deb98c724526fd2164";
    /*我的公众号配置 end*/

    /**微信模板id*/
    // 绑定账号成功通知
    public static final String BIND_SUCCESS_TEMPLE = "n_tt-yzj5ly55xUVsgbi5vZY6HlZAMLFkiDJZjTdEdA";
    /**微信模板id*/
    public static final String UNBUND_TEMPLE = "C3jLD_OlQ57Mf1Bq5Z9KvrBdOvTK2ezC_I98XKL5CgE";

    //获取access_token的url
    public static final String BASE_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?";
    //固定值
    public static final String GRANT_TYPE = "client_credential";




    public static final String CREATE_MENU_URL="https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

    public static final String RESP_MESSAGE_TYPE_TEXT = "text";
    public static final Object REQ_MESSAGE_TYPE_TEXT = "text";
    public static final Object REQ_MESSAGE_TYPE_IMAGE = "image";
    public static final Object REQ_MESSAGE_TYPE_VOICE = "voice";
    public static final Object REQ_MESSAGE_TYPE_VIDEO = "video";
    public static final Object REQ_MESSAGE_TYPE_LOCATION = "location";
    public static final Object REQ_MESSAGE_TYPE_LINK = "link";
    public static final Object REQ_MESSAGE_TYPE_EVENT = "event";
    public static final Object EVENT_TYPE_SUBSCRIBE = "subscribe";
    public static final Object EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";
    public static final Object EVENT_TYPE_SCAN = "SCAN";
    public static final Object EVENT_TYPE_LOCATION = "LOCATION";
    public static final Object EVENT_TYPE_CLICK = "CLICK";

    public static final String FromUserName = "FromUserName";
    public static final String ToUserName = "ToUserName";
    public static final String MsgType = "MsgType";
    public static final String Content = "Content";
    public static final String Event = "Event";





}
