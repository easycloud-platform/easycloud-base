package cn.catbar.easycloud.wechat.bean;

/**
 * 跳转到微信小程序button
 */
public class WxMiniProgramButton extends WxButton {

    private String url;

    private String appid;

    private String pagepath;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPagepath() {
        return pagepath;
    }

    public void setPagepath(String pagepath) {
        this.pagepath = pagepath;
    }
}
