package design.decorative;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 调味品
 * @author zhaomingjie
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class CondimentDecorator extends Beverage implements ICondimentDecorator {

     public Beverage beverage;

    /**
     * 获取描述
     * @return
     */
    @Override
    public abstract String getDescription();

    public Beverage condiment(){
        return this;
    }

    /**
     * 设置beverage
     */
    @Override
    public abstract void setBeverage(Beverage beverage);


}
