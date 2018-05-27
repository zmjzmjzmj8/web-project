package design.decorative;

/**
 * @author zhaomingjie
 */
@FunctionalInterface
public interface ICondimentDecorator {
    /**
     * 设置beverage
     */
    void setBeverage(Beverage beverage);
}

