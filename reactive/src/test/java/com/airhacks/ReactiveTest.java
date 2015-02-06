package com.airhacks;

import javafx.beans.property.SimpleIntegerProperty;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class ReactiveTest {

    @Test
    public void wikipediaDefinition() {
        SimpleIntegerProperty a = new SimpleIntegerProperty();
        SimpleIntegerProperty b = new SimpleIntegerProperty(1);
        SimpleIntegerProperty c = new SimpleIntegerProperty(2);

        a.bind(b.multiply(c));
        a.addListener((observable, oldValue, newValue) -> {
            System.out.println("n " + newValue);
        });
        b.set(21);
        c.set(2);
    }
}
