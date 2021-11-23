package com.product.promotion;

import com.product.promotion.cmd.CmdLine;
import com.product.promotion.menu.MenuService;
import com.product.promotion.model.Item;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        init();
        CmdLine cd = new CmdLine();
        cd.welcomeMessage();
    }

    /**
     * Calling init method to add SKU items to menu service
     */
    public static void init() {
        Item i1 = new Item(1, "A", 50.0);
        Item i2 = new Item(2, "B", 30.0);
        Item i3 = new Item(3, "C", 20.0);
        Item i4 = new Item(4, "D", 15.0);
        MenuService menuService = new MenuService();
        menuService.addItems(i1);
        menuService.addItems(i2);
        menuService.addItems(i3);
        menuService.addItems(i4);
    }
}
