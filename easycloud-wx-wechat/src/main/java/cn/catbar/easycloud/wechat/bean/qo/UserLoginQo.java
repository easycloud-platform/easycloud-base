package cn.catbar.easycloud.wechat.bean.qo;


public class UserLoginQo {

    private String userName;

    private String passWord;

    private String openid;

    private String url;

    private String unbund;

    public String getUnbund() {
        return unbund;
    }

    public void setUnbund(String unbund) {
        this.unbund = unbund;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "UserLoginQo{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", openid='" + openid + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
