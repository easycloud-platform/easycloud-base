/**    
 * @Title: GetPageOpenidBean.java  
 * @Package net.microcental.easysite.weixin.insert.entity  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author wxt.chens   
 * @date 2017年9月14日 下午5:21:42  
 * @version V1.0
 */
package cn.catbar.easycloud.wechat.bean;

/**  
 * @ClassName: GetPageOpenidBean  
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2017年9月14日 下午5:21:42    
 */
public class GetPageOpenidBean {
	private String access_token;
	private String expires_in;
	private String refresh_token;
	private String openid;
	private String scope;
	
	/**
	 * @return the access_token
	 */
	public String getAccess_token() {
		return access_token;
	}
	/**
	 * @param access_token the access_token to set
	 */
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	/**
	 * @return the expires_in
	 */
	public String getExpires_in() {
		return expires_in;
	}
	/**
	 * @param expires_in the expires_in to set
	 */
	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}
	/**
	 * @return the refresh_token
	 */
	public String getRefresh_token() {
		return refresh_token;
	}
	/**
	 * @param refresh_token the refresh_token to set
	 */
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}
	/**
	 * @return the openid
	 */
	public String getOpenid() {
		return openid;
	}
	/**
	 * @param openid the openid to set
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	/**
	 * @return the scope
	 */
	public String getScope() {
		return scope;
	}
	/**
	 * @param scope the scope to set
	 */
	public void setScope(String scope) {
		this.scope = scope;
	}


	@Override
	public String toString() {
		return "GetPageOpenidBean{" +
				"access_token='" + access_token + '\'' +
				", expires_in='" + expires_in + '\'' +
				", refresh_token='" + refresh_token + '\'' +
				", openid='" + openid + '\'' +
				", scope='" + scope + '\'' +
				'}';
	}
}
