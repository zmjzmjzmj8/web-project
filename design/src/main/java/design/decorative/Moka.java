package design.decorative;


/**
 * 摩卡
 * @author zhaomingjie
 */
public class Moka extends Beverage {

    public Moka() {
        description="Moka Beverage";
    }

    @Override
    public Double cost() {
        return 3.5;
    }
}
