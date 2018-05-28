package com.zmj.project.web.domain;

import com.zmj.project.common.domain.BaseDomain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;


/**
 * 测试表单
 *
 * @ClassName: DemoForm
 * @Description: 测试表单
 * @Author: zhaomingjie
 * @CreateDate: 2018/5/28 10:22
 * @UpdateUser: zhaomingjie
 * @UpdateDate: 2018/5/28 10:22
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DemoForm extends BaseDomain {

    @NotEmpty(message = "id不能为空")
    private String id;

    @NotEmpty(message = "name不能为空")
    private String name;

    private int sex;


}
