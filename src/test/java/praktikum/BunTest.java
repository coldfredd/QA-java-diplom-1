package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;
    private static final double DELTA = 0.0;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"Bun Bun", 1},
                {"@weet", 2.5f},
                {"123", 5.0f},
                {null, 6.0f},
                {"", 7.0f},
                {"Cheap bun", Float.MIN_VALUE},
                {"Expensive bun", Float.MAX_VALUE}
        };
    }
    public BunTest (String name, float price){
        this.name = name;
        this.price = price;
    }
    @Test
    public void testGetName() {
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName());
    }
    @Test
    public void testGetPrice() {
        Bun bun = new Bun(name, price);
        assertEquals(price, bun.getPrice(), DELTA);
    }
}