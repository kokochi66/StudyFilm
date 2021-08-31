package sample2.kokochi.hello.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StatefulService {

    int order(String name, int price) {
        System.out.println("name = " + name +"  // price = " + price);
        return price;
    }

}
