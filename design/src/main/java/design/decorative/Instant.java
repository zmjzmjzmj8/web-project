package design.decorative;

/**
 * 速溶
 * @author zhaomingjie
 */
public class Instant extends Beverage{

    public Instant() {
        description="Instant Beverage";
    }

    @Override
    public Double cost() {
        return 2.5;
    }
}
