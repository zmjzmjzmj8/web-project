package design.decorative;

public class Test {

    @org.junit.jupiter.api.Test
    public void main() {
        IBeverage moka = new Moka();
        Beverage beverage = moka.addCondiment(new Sugar()).addCondiment(new Chocolate());
        System.out.println(beverage.getDescription());
        System.out.println(beverage.cost());
        System.out.println(moka);
        System.out.println(beverage);
    }
}
