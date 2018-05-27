package design.decorative;


/**
 * 饮料抽象接口
 * @author zhaomingjie
 */
@FunctionalInterface
public interface IBeverage {
    /**
     * 添加调味品
     * @param condimentDecorator
     * @return
     */
    Beverage addCondiment(CondimentDecorator condimentDecorator);
}
