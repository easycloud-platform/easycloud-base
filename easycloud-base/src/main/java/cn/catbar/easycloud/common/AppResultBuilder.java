package cn.catbar.easycloud.common;

import cn.catbar.easycloud.common.bean.AppResult;
import cn.catbar.easycloud.common.eum.ResultCode;

/**
 * 返回构造器
 */
public class AppResultBuilder {

    //成功，不返回具体数据
    public static <T> AppResult<T> successNoData(ResultCode code){
        AppResult<T> result = new AppResult<T>();
        result.setCode(code.getCode());
        result.setMsg(code.getMsg());
        return result;
    }
    //成功，返回数据
    public static <T> AppResult<T> success(T t,ResultCode code){
        AppResult<T> result = new AppResult<T>();
        result.setCode(code.getCode());
        result.setMsg(code.getMsg());
        result.setData(t);
        return result;
    }

    //失败，返回失败信息
    public static <T> AppResult<T> faile(ResultCode code){
        AppResult<T> result = new AppResult<T>();
        result.setCode(code.getCode());
        result.setMsg(code.getMsg());
        return result;
    }

}
