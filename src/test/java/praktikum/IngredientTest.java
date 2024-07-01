package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {SAUCE, "hot sauce", Float.MAX_VALUE},
                {FILLING,"Cheap bun", Float.MIN_VALUE}
        };
    }

    public IngredientTest(IngredientType type, String name, float price){
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Test
    public void testGetIngredient(){
        Ingredient ingredient = new Ingredient(type,name,price);
        assertEquals(type, ingredient.getType());
    }
    @Test
    public void testGetName(){
        Ingredient ingredient = new Ingredient(type,name,price);
        assertEquals(name, ingredient.getName());
    }
    @Test
    public void testGetPrice(){
        Ingredient ingredient = new Ingredient(type,name,price);
        assertEquals(price, ingredient.getPrice(),0.0);
    }
}