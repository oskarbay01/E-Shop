package com.example.springdemo2.services.impl;

import com.example.springdemo2.entities.Categories;
import com.example.springdemo2.entities.Countries;
import com.example.springdemo2.entities.ShopItems;
import com.example.springdemo2.repositories.CategoryRepo;
import com.example.springdemo2.repositories.CountriesRepo;
import com.example.springdemo2.repositories.ShopItemRepo;
import com.example.springdemo2.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemShopImpl implements ItemService {

    @Autowired
    private ShopItemRepo shopItemRepo;

    @Autowired
    private CountriesRepo countriesRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public ShopItems addItem(ShopItems item) {
        return shopItemRepo.save(item);
    }

    @Override
    public List<ShopItems> getAllItems() {
        return shopItemRepo.findAllByAmountGreaterThanOrderByPriceDesc(0);
    }

    @Override
    public ShopItems getItem(Long id) {
        return shopItemRepo.findAllByIdAndAmountGreaterThan(id,0);
    }

    @Override
    public void deleteItem(ShopItems item) {
        shopItemRepo.delete(item);
    }

    @Override
    public ShopItems saveItem(ShopItems item) {
        return shopItemRepo.save(item);
    }

    @Override
    public List<Countries> getAllContries() {
        return countriesRepo.findAll();
    }

    @Override
    public Countries addCountry(Countries country) {
        return countriesRepo.save(country);
    }

    @Override
    public Countries saveCountry(Countries country) {
        return countriesRepo.save(country);
    }

    @Override
    public Countries getCountry(Long id) {
        return countriesRepo.getOne(id);
    }

    @Override
    public List<Categories> getAllCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public Categories getCategory(Long id) {
        return categoryRepo.getOne(id);
    }

    @Override
    public Categories saveCategory(Categories category) {
        return categoryRepo.save(category);
    }

    @Override
    public Categories addCategory(Categories category) {
        return categoryRepo.save(category);
    }

}
