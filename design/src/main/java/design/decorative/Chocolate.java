package design.decorative;

import lombok.NoArgsConstructor;

/**
 * 巧克力装饰者
 * @author zhaomingjie
 */
@NoArgsConstructor
public class Chocolate extends CondimentDecorator {

    public Chocolate(Beverage beverage) {
        description=beverage.description+" , chocolate";
    }

    @Override
    public void setBeverage(Beverage beverage) {
        description=beverage.description+" , chocolate";
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
        return beverage.cost()+1.5;
    }

}
