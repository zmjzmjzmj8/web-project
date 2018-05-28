package com.zmj.project.common.util;

import com.zmj.project.common.domain.RestfulResult;
import com.zmj.project.common.enums.ErrorCode;
import com.zmj.project.common.enums.SuccessCode;
import net.sf.json.JSONObject;

/**
 * RestfulResult对象工厂工具
 * @author zmj
 */
public class RestfulResultBuilder {

    /**
     * 返回成功
     * @param object
     * @return
     */
    public static RestfulResult success(Object object){
        RestfulResult restfulResult = new RestfulResult(SuccessCode.SYS_CODE_STATUS_SUCCESS);
        restfulResult.setResult(object);
        return restfulResult;
    }

    /**
     * 返回成功，并且无返回实体
     * @return
     */
    public static RestfulResult success(){
        return success(null);
    }

    /**
     * 返回失败
     * @param code
     * @param msg
     * @return
     */
    public static RestfulResult error(Integer code,String msg){
        RestfulResult restfulResult = new RestfulResult();
        restfulResult.setStatus(code);
        restfulResult.setMsg(msg);
        restfulResult.setResult(null);
        return restfulResult;
    }

    /**
     * 返回失败
     * @param errorCode
     * @param msg
     * @return
     */
    public static RestfulResult error(ErrorCode errorCode, String msg){
        RestfulResult restfulResult = new RestfulResult(errorCode);
        restfulResult.setMsg(msg);
        restfulResult.setResult(null);
        return restfulResult;
    }

    /**
     * 返回失败
     * @param errorCode
     * @return
     */
    public static RestfulResult error(ErrorCode errorCode){
        RestfulResult restfulResult = new RestfulResult(errorCode);
        restfulResult.setResult(null);
        return restfulResult;
    }

    @Override
    public String toString() {
        return JSONObject.fromObject(this).toString();
    }
}
