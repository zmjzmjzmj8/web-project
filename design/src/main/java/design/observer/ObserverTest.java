package design.observer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Observable;
import java.util.Observer;
import java.util.Optional;

/**
 * 观察者模式
 * @author zhaomingjie
 */
public class ObserverTest {

    @AllArgsConstructor
    @Getter
    @Setter
    public class House extends Observable{
        private BigDecimal price;

        public void setPrice(BigDecimal price) {
            this.setChanged();
            this.notifyObservers(price);
            this.price = price;
        }

        @Override
        public String toString() {
            return "价格为："+price;
        }
    }

    @NoArgsConstructor
    @Getter
    @Setter
    public class Buyer implements Observer{
        private House house;
        private String name;

        public Buyer(String name) {
            this.name = name;
        }

        public Buyer(House house, String name) {
            this.house = house;
            this.name = name;
            house.addObserver(this);
        }

        /**
         * This method is called whenever the observed object is changed. An
         * application calls an <tt>Observable</tt> object's
         * <code>notifyObservers</code> method to have all the object's
         * observers notified of the change.
         *
         * @param o   the observable object.
         * @param arg an argument passed to the <code>notifyObservers</code>
         */
        @Override
        public void update(Observable o, Object arg) {
            Optional<Object> price =Optional.ofNullable(arg);
            price.ifPresent(p->{
              if(p instanceof BigDecimal){
                  System.out.println(name+"接受到价格变动，price："+p);
              }
            });
        }
    }

    @Test
    public void main() {
        House house = new House(new BigDecimal("100"));
        Buyer buyera = new Buyer("aaa");
        Buyer buyerb = new Buyer(house,"bbb");
        house.addObserver(buyera);
        house.setPrice(house.getPrice().add(new BigDecimal("10")));
    }
}
