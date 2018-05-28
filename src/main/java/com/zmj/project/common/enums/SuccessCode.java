package com.zmj.project.common.enums;

/**
 * 成功返回码
 *
 * @ClassName: ${TYPE_NAME}
 * @Description: 成功返回码
 * @Author: zhaomingjie
 * @CreateDate: 2018/5/28 10:43
 * @UpdateUser: zhaomingjie
 * @UpdateDate: 2018/5/28 10:43
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public enum SuccessCode implements CodeInterface{
    //系统返回代码
    SYS_CODE_STATUS_SUCCESS(200, "成功"),
    ;

    /**
     * 说明
     */
    String description;

    /**
     * 代码
     */
    int code;

    SuccessCode() {
    }

    SuccessCode(int code, String description) {
        this.description = description;
        this.code = code;
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

    @Override
    public String getInfo() {
        return this.description;
    }

    @Override
    public void print() {
        System.out.println(this.code + ":" + this.description);
    }

    public static SuccessCode codeOf(int code) {
        for (SuccessCode codes : values()) {
            if (codes.getCode() == code) {
                return codes;
            }
        }

        return null;
    }
}
