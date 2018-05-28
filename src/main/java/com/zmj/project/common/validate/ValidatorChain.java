package com.zmj.project.common.validate;

import com.zmj.project.common.validate.exception.ValidationException;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * 校验链
 * @author zhaomingjie
 */
@Getter
@Setter
public class ValidatorChain implements Validator {

    private List<Validator> validators;

    public ValidatorChain() {
    }

    public ValidatorChain(List<Validator> validators) {
        this.validators = validators;
    }

    @Override
    public void validate(Object model) throws ValidationException {
        Optional<List<Validator>> optionalValidators = Optional.ofNullable(validators);
        List<Validator> validators = optionalValidators.orElse(new ArrayList());
        for (Validator v:validators) {
            v.validate(model);
        }
    }

    public ValidatorChain addValidator(Validator... validator){
        Optional<List<Validator>> vcp = Optional.ofNullable(validators);
        validators = vcp.orElse(new ArrayList());
        Collections.addAll(vcp.get(), validator);
        return this;
    }

    public ValidatorBuilder builder(){
        return new ValidatorBuilder();
    }
}
