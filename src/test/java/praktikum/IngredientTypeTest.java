package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTypeTest {
    @Test
    public void testIngredientTypeSauce() {
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }
    @Test
    public void testIngredientTypeFilling() {
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }
}