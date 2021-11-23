package com.product.promotion.checkout;

import com.product.promotion.menu.MenuService;
import com.product.promotion.model.Item;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CheckoutServiceTest {

    @Mock
    MenuService menuService;

    @InjectMocks
    CheckoutService checkoutService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        menuService = mock(MenuService.class);
        checkoutService = new CheckoutService();
    }

    @Test
    public void getTotalPriceErrorTest() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("C", 1);
        map.put("D", 1);
        List<Item> itemsList = new ArrayList<>();
        boolean thrown = false;
        Item i1 = new Item(3, "C", 20);
        Item i2 = new Item(4, "D", 15);
        itemsList.add(i1);
        itemsList.add(i2);
        try {
            when(menuService.getItems()).thenReturn(itemsList);

            assertEquals(30, checkoutService.checkoutItems(map));
        } catch (IndexOutOfBoundsException e) {
            thrown = true;
        }
        assert (thrown);
    }

    @Test
    public void getTotalPriceTest() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("C", 1);
        map.put("D", 1);
        CheckoutService checkoutService = new CheckoutService();

        double total = checkoutService.getCDSKUPrice(1, 1, 35);
        assertEquals(30.0, total, 0.0);
    }
}
