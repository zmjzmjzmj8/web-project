package design.decorative;

import lombok.NoArgsConstructor;

/**
 * 抹茶装饰者
 * @author zhaomingjie
 */
@NoArgsConstructor
public class Matcha extends CondimentDecorator {

    public Matcha(Beverage beverage) {
        description = beverage.description+" , Matcha";
    }

    @Override
    public void setBeverage(Beverage beverage) {
        description = beverage.description+" , Matcha";
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
        return beverage.cost()+0.2;
    }
}
