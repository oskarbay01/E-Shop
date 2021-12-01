package com.example.springdemo2.services;

import com.example.springdemo2.entities.Categories;
import com.example.springdemo2.entities.Countries;
import com.example.springdemo2.entities.ShopItems;

import java.util.List;

public interface ItemService {
    ShopItems addItem(ShopItems item);

    List<ShopItems> getAllItems();

    ShopItems getItem(Long id);

    void deleteItem(ShopItems item);

    ShopItems saveItem(ShopItems item);

    List<Countries> getAllContries();

    Countries addCountry(Countries country);

    Countries saveCountry(Countries country);

    Countries getCountry(Long id);

    List<Categories> getAllCategories();

    Categories getCategory(Long id);

    Categories saveCategory(Categories category);

    Categories addCategory(Categories category);

}
