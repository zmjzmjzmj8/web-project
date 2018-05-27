package design.decorative;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 饮料基类
 * @author zhaomingjie
 */
@Getter
@Setter
@NoArgsConstructor
public abstract class Beverage implements IBeverage{

    public String description;

    public abstract Double cost();

    @Override
    public Beverage addCondiment(CondimentDecorator condimentDecorator){
        condimentDecorator.setBeverage(this);
        return condimentDecorator.condiment();
    }

    @Override
    public String toString() {
        return description+"  cost:"+cost();
    }
}
