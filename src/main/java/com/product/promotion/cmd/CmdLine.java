package com.product.promotion.cmd;


import com.product.promotion.cart.CartService;
import com.product.promotion.checkout.CheckoutService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CmdLine {

    /**
     * Read data from console
     *
     * @throws IOException
     */
    public void welcomeMessage() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Hola!!! Welcome to DM Services!!!\nWe have A, B, C, D items in our mart" +
                "\nWe have special offers for you!!!\nBuy 3A for 130 unit\nBuy 2B for 45 unit\nBuy SKU C and D for 30 unit\nPlease choose the products you wish to order\n");
        CartService cartService = new CartService();
        System.out.println("Please enter \"END\" once you added all items to cart");

        String type = br.readLine();
        while (!type.equalsIgnoreCase("END")) {
            if (!type.equalsIgnoreCase("A") && !type.equalsIgnoreCase("B") && !type.equalsIgnoreCase("C") && !type.equalsIgnoreCase("D")) {
                System.out.println("Please enter valid item");
            } else {
                cartService.addItems(type);
            }
            type = br.readLine();
        }
        System.out.println("Here is the list of items you added to cart: " +
                cartService.getListOfItems());

        CheckoutService checkoutService = new CheckoutService();
        double totalUnitCost = checkoutService.checkoutItems(cartService.getItems());
        System.out.println("Total" + totalUnitCost);
    }
}
