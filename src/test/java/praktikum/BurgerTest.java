package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient1;
    @Mock
    Ingredient ingredient2;

    @Before
    public void setBurger(){
        burger = new Burger();
        burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(2.0f);
        Mockito.when(bun.getName()).thenReturn("Burger King");

        Mockito.when(ingredient1.getPrice()).thenReturn(1.5f);
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient1.getName()).thenReturn("Bacon");

        Mockito.when(ingredient2.getPrice()).thenReturn(2.3f);
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient2.getName()).thenReturn("Onion ring");
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        List<Ingredient> ingredients = burger.ingredients;
        assertEquals(2,ingredients.size());
    }
    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.removeIngredient(0);

        List<Ingredient> ingredients = burger.ingredients;

        assertEquals(1,ingredients.size());
    }
    @Test
    public void testMoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.moveIngredient(0,1);
        List<Ingredient> ingredients = burger.ingredients;
        assertEquals(ingredient2,ingredients.get(0));
        assertEquals(ingredient1,ingredients.get(1));
    }
    @Test
    public void testGetPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        float expectedPrice = bun.getPrice()*2 + ingredient1.getPrice()+ingredient2.getPrice();
        assertEquals(expectedPrice, burger.getPrice(), 0.001);
    }
    @Test
    public void testGetReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        String expectedReceipt = String.format("(==== %s ====)%n= filling Bacon =%n= sauce Onion ring =%n(==== %s ====)%n%nPrice: %f%n",
                bun.getName(), bun.getName(), burger.getPrice());
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}