package design.decorative;

import lombok.NoArgsConstructor;

/**
 * 糖修饰者
 * @author zhaomingjie
 */
@NoArgsConstructor
public class Sugar extends CondimentDecorator {

    public Sugar(Beverage beverage) {
        description= beverage.description+" , sugar";
    }

    @Override
    public void setBeverage(Beverage beverage) {
        description= beverage.description+" , sugar";
        super.beverage = beverage;
    }

    /**
     * 获取描述
     *
     * @return
     */
    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Double cost() {
        return beverage.cost()+0.1;
    }
}
