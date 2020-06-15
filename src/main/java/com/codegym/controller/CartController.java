package com.codegym.controller;

import com.codegym.model.Cart;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("cart")
public class CartController {

    @ModelAttribute("cart")
    public Cart setUpCart(){
        return new Cart();
    }

    @GetMapping("/carts")
    public ModelAndView  moveToCartPage(@ModelAttribute("cart") Cart cart){
        ModelAndView modelAndView = new ModelAndView("cart/list");
        System.out.println(cart.getProducts().get(0).getName());
        return modelAndView;
    }

}