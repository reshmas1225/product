package com.product.promotion.menu;

import com.product.promotion.model.Item;

import java.util.ArrayList;
import java.util.List;

public class MenuService {

    static List<Item> items = new ArrayList<>();

    /**
     * Add items to Menu card
     *
     * @param item
     */
    public void addItems(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

}
