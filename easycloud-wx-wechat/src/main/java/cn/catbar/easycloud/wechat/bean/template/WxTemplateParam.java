package cn.catbar.easycloud.wechat.bean.template;



/**
 * @Author Lee Qian
 * @Description 微信模版需要的数据
 * @Date 2018/11/28
 */
public class WxTemplateParam {

    // 参数名称

    private String name;

    // 参数值

    private String value;

    // 颜色

    private String color;


    public WxTemplateParam(String name, String value, String color){
        this.name = name;
        this.value = value;
        this.color =color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
