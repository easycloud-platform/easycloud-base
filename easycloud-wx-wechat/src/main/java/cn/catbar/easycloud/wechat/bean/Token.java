package cn.catbar.easycloud.wechat.bean;

/**
 * 防止Token过期
 */
public class Token {

    //接口访问凭证
    private String accessToken;
    //有效期限
    private int expiresIn;
    //获取token的最新时间
    private long addTime;
    //签名
    private String ticket;
    public String getAccessToken() {
        return accessToken;
    }
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    public int getExpiresIn() {
        return expiresIn;
    }
    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }
    public long getAddTime() {
        return addTime;
    }
    public void setAddTime(long addTime) {
        this.addTime = addTime;
    }
    public String getTicket() {
        return ticket;
    }
    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

}
