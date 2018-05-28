package com.zmj.project.web.controller;

import com.zmj.project.common.domain.RestfulResult;
import com.zmj.project.common.util.RestfulResultBuilder;
import com.zmj.project.common.validate.ValidatorBuilder;
import com.zmj.project.common.validate.ValidatorChain;
import com.zmj.project.common.validate.exception.ValidationException;
import com.zmj.project.web.validator.DemoValidator;
import com.zmj.project.web.domain.DemoForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
    Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 测试校验链路建造器，自定义校验器
     * @return
     * @throws ValidationException
     */
    @RequestMapping("/testValidate")
    public String testValidate() throws ValidationException {
        logger.info("testValidate");
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

    @RequestMapping("/testValidate3")
    @ResponseBody
    public RestfulResult testValidate3(@Valid DemoForm demoForm, BindingResult bindingResult) throws ValidationException {
        return RestfulResultBuilder.success(demoForm);
    }
}