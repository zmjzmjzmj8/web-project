package com.zmj.project.common.validate;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
@NoArgsConstructor
public class ValidatorBuilder {
    private List<Validator> validators;

    public ValidatorBuilder addValidator(Validator... validator){
        Optional<List<Validator>> vcp = Optional.ofNullable( validators);
        validators = vcp.orElse(new ArrayList<>());
        Collections.addAll(validators, validator);
        return this;
    }

    public ValidatorChain build(){
        try {
            return new ValidatorChain(validators);
        }finally {
            validators=null;
        }
    }

}
