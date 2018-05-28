package com.zmj.common.validate;


import com.zmj.common.validate.exception.ValidationException;

/**
 * 校验器
 * @author zhaomingjie
 */
@FunctionalInterface
public interface Validator {
    /**
     * 校验方法
     * @param obj
     * @throws ValidationException
     */
    void validate(Object obj) throws ValidationException;

    default void doValidate(Object obj) throws ValidationException{
        try {
            validate(obj);
        }catch (ValidationException e){
            throw e;
        }catch (Exception e){
            throw new ValidationException(e);
        }
    }
}
