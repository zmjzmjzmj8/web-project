package design.decorative;

/**
 * 拿铁
 * @author zhaomingjie
 */
public class Latte extends Beverage{
    public Latte() {
        description="Latte Beverage";
    }

    @Override
    public Double cost() {
        return 4.5;
    }
}
