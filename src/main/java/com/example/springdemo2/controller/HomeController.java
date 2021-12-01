package com.example.springdemo2.controller;

import com.example.springdemo2.entities.Categories;
import com.example.springdemo2.entities.Countries;
import com.example.springdemo2.entities.ShopItems;
import com.example.springdemo2.entities.Users;
import com.example.springdemo2.services.ItemService;
import com.example.springdemo2.services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String index(Model model) {

        model.addAttribute("currentUser", getUserData());

        List<ShopItems> items = itemService.getAllItems();
        model.addAttribute("tovary", items);


        List<Countries> countries = itemService.getAllContries();
        model.addAttribute("countries", countries);
        return "index";
    }

    @GetMapping(value = "/about")
    public String about(Model model) {
        model.addAttribute("currentUser", getUserData());
        return "about";
    }

    @PostMapping(value = "/additem")
    public String additem(@RequestParam(name = "item_name", defaultValue = "No item") String name,
                          @RequestParam(name = "item_price", defaultValue = "0") int price,
                          @RequestParam(name = "country_id", defaultValue = "0") Long id,
                          @RequestParam(name = "item_amount", defaultValue = "0") int amount) {

        Countries cnt = itemService.getCountry(id);

        if (cnt != null) {
            ShopItems shopItems = new ShopItems();
            shopItems.setName(name);
            shopItems.setAmount(amount);
            shopItems.setPrice(price);
            shopItems.setCountry(cnt);

            itemService.addItem(shopItems);

        }

        return "redirect:/";
    }

    @GetMapping(value = "/details/{idshka}")
    public String details(Model model, @PathVariable(name = "idshka") Long id) {
        ShopItems item = itemService.getItem(id);
        model.addAttribute("item", item);

        List<Countries> countries = itemService.getAllContries();
        model.addAttribute("countries", countries);

        List<Categories> categories = itemService.getAllCategories();
        model.addAttribute("categories", categories);
        return "details";
    }

    @PostMapping(value = "/deleteitem")
    public String deleteItem(@RequestParam(name = "id", defaultValue = "0") Long id) {


        ShopItems item = itemService.getItem(id);
        if (item != null) {
            itemService.deleteItem(item);
        }
        return "redirect:/";
    }

    @PostMapping(value = "/saveitem")
    public String saveItem(@RequestParam(name = "id", defaultValue = "0") Long id,
                           @RequestParam(name = "item_name", defaultValue = "No item") String name,
                           @RequestParam(name = "item_price", defaultValue = "0") int price,
                           @RequestParam(name = "item_amount", defaultValue = "0") int amount) {


        ShopItems item = itemService.getItem(id);
        if (item != null) {
            item.setName(name);
            item.setAmount(amount);
            item.setPrice(price);
            itemService.saveItem(item);
        }
        return "redirect:/";
    }

    @GetMapping(value = "/403")
    public String accessDenied(Model model){
        model.addAttribute("currentUser", getUserData());
        return "403";
    }


    @GetMapping(value = "/login")
    public String login(Model model){
        model.addAttribute("currentUser", getUserData());
        return "login";
    }

    @GetMapping(value = "/profile")
    @PreAuthorize("isAuthenticated()")
    public String profile(Model model){
        model.addAttribute("currentUser", getUserData());
        return "profile";
    }

    private Users getUserData(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)){
            User secUser = (User) authentication.getPrincipal();
            Users myUser = userService.getUserByEmail(secUser.getUsername());
            return myUser;
        }
        return null;
    }
}
