package com.example.springdemo2.db;

import java.util.ArrayList;

public class DBManager {
    private static ArrayList<Items> items = new ArrayList<>();
    private static Long id = 5L;

    static {
        items.add(new Items(1L, "Iphone 13", 555000));
        items.add(new Items(2L, "Iphone 12", 480000));
        items.add(new Items(3L, "Huamei Pro p30", 275000));
        items.add(new Items(4L, "Samsung 12", 500000));
    }

    public static ArrayList<Items> getItems() {
        return items;
    }

    public static void addItem(Items item){
        item.setId(id);
        items.add(item);
        id++;
    }

    public static Items getItem(Long id){
        for (Items it: items) {
        if (it.getId()==id)
            return it;
        }
        return null;
    }
}
