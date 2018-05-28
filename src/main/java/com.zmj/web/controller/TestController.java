package com.zmj.web.controller;

import com.zmj.common.validate.*;
import com.zmj.common.validate.exception.ValidationException;
import com.zmj.web.validator.DemoValidator;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * code is far away from bug with the animal protecting
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 *
 * @author : zmj
 * @description :
 * ---------------------------------
 */
@RestController
public class TestController {

    /**
     * 测试校验链路建造器，自定义校验器
     * @return
     * @throws ValidationException
     */
    @RequestMapping("/testValidate")
    public String testValidate() throws ValidationException {
        Object o =null;
        ValidatorChain validatorChain = new ValidatorBuilder()
                .addValidator(new DemoValidator()).build();
        validatorChain.doValidate(o);
        return null;
    }

    /**
     * 测试校验链路建造器，lambda匿名方法
     * @return
     * @throws ValidationException
     */
    @RequestMapping("/testValidate2")
    public String testValidate2() throws ValidationException {
        Object o =null;
        ValidatorChain validatorChain = new ValidatorBuilder()
                .addValidator(obj ->Assert.notNull(o,"o不能为空"))
                .build();
        validatorChain.doValidate(o);
        return null;
    }
}
