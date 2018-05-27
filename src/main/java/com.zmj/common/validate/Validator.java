package com.zmj.common.validate;


import com.zmj.common.validate.exception.ValidationException;

/**
 * 校验器
 * @author zhaomingjie
 */
@FunctionalInterface
public interface Validator {
    void validate(Object obj) throws ValidationException;
}
