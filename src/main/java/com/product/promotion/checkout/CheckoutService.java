package com.product.promotion.checkout;

import com.product.promotion.menu.MenuService;
import com.product.promotion.model.Item;

import java.util.List;
import java.util.Map;

public class CheckoutService {

    /**
     * Method to return Fixed SKU price of C,D
     *
     * @param counterOfC
     * @param counterOfD
     * @param totalPriceOfCD
     * @return
     */
    public static double getCDSKUPrice(double counterOfC, double counterOfD, double totalPriceOfCD) {
        if (counterOfC == 1 && counterOfD == 1) {
            return 30;
        }
        return totalPriceOfCD;
    }

    /**
     * To get total items price
     *
     * @param items
     * @return
     */
    public double checkoutItems(Map<String, Integer> items) {

        int counterOfA = 0;
        int counterOfB = 0;
        int counterOfC = 0;
        int counterOfD = 0;
        MenuService menuService = new MenuService();
        List<Item> serviceItems = menuService.getItems();

        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            switch (entry.getKey()) {
                case "A":
                    counterOfA = entry.getValue();
                    break;
                case "B":
                    counterOfB = entry.getValue();
                    break;
                case "C":
                    counterOfC = entry.getValue();
                    break;
                case "D":
                    counterOfD = entry.getValue();
                    break;
            }
        }

        double totalPriceOfA = (counterOfA / 3) * 130 + (counterOfA % 3 * serviceItems.get(0).getPrice());
        double totalPriceOfB = (counterOfB / 2) * 45 + (counterOfB % 2 * serviceItems.get(1).getPrice());
        double totalPriceOfC = (counterOfC * serviceItems.get(2).getPrice());
        double totalPriceOfD = (counterOfD * serviceItems.get(3).getPrice());
        double priceofCD = getCDSKUPrice(counterOfC, counterOfD, totalPriceOfC + totalPriceOfD);
        return totalPriceOfA + totalPriceOfB + priceofCD;
    }
}
