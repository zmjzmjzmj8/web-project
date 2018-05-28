package com.zmj.project.common.enums;

/**
 * 错误枚举
 *
 * @ClassName: ${TYPE_NAME}
 * @Description: 错误枚举
 * @Author: zhaomingjie
 * @CreateDate: 2018/5/28 10:37
 * @UpdateUser: zhaomingjie
 * @UpdateDate: 2018/5/28 10:37
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public enum ErrorCode implements CodeInterface{
    DATEBASE_ERRPR(1001,"数据库操作异常"),
    NULL_ERROR(301,"空异常"),
    VERIFY_ERROR(302,"验证异常"),
    FILE_UPLOAD_ERROR(401,"文件上传异常"),
    NOT_LOGIN(403,"未登录"),
    NOT_FIND_ERROR(601,"数据未找到"),
    ISHAVEN_ERROR(602,"数据已经存在"),
    NOT_FIND_USER_ERROR(603,"未找到该用户"),
    NOT_FIND_USER_ERROR2(604,"未找到该用户"),
    TOKEN_ERROR(605,"token异常"),
    GET_TOKEN_ERROR(607,"验证token异常"),
    KNOWS_ERROR(500, "已知异常"),
    UNKNOWNS_ERROR(501, "未知异常"),
    HTTPREQUESTMETHODNOTSUPPORTED(405,"请求方法不被允许"),
    INSUFFICIENT_BALANCE(701,"余额不足"),

    ;
    /**
     * 说明
     */
    String description;

    /**
     * 代码
     */
    int code;

    ErrorCode( int code ,String description) {
        this.description = description;
        this.code = code;
    }

    @Override
    public String getInfo() {
        return this.description;
    }

    @Override
    public void print() {
        System.out.println(this.code + ":" + this.description);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
