package com.zmj.project.common.domain;

import com.zmj.project.common.enums.CodeInterface;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.sf.json.JSONObject;

/**
 * http返回restful对象
 * @author zmj
 */
@NoArgsConstructor
@Getter
@Setter
public class RestfulResult<T> extends BaseDomain{

    /**
     * 状态码
     */
    private Integer status;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体内容
     */
    private T result;

    public RestfulResult(CodeInterface codeInterface) {
        status=codeInterface.getCode();
        msg=codeInterface.getInfo();
    }


    @Override
    public String toString() {
        return JSONObject.fromObject(this).toString();
    }
}
