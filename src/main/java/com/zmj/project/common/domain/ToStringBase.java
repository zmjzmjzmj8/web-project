package com.zmj.project.common.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * java类简单作用描述
 *
 * @ClassName: ${TYPE_NAME}
 * @Description: java类作用描述
 * @Author: zhaomingjie
 * @CreateDate: 2018/5/28 10:49
 * @UpdateUser: zhaomingjie
 * @UpdateDate: 2018/5/28 10:49
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class ToStringBase {
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
