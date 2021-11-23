package com.product.promotion.cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartService {

    List<String> cartList = new ArrayList<String>();
    Map<String, Integer> map = new HashMap<String, Integer>();

    /**
     * Add items to map
     *
     * @param item
     */
    public void addItems(String item) {
        if (map.containsKey(item)) {
            map.put(item, map.get(item) + 1);
        } else {
            map.put(item, 1);
        }
    }

    /**
     * Get list of n items added to cart
     *
     * @return
     */
    public List getListOfItems() {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            cartList.add(entry.getValue() + entry.getKey());
        }
        return cartList;
    }

    public Map<String, Integer> getItems() {
        return map;
    }
}
