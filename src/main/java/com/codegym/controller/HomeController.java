package com.codegym.controller;

import com.codegym.model.Cart;
import com.codegym.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("cart")
@RequestMapping("/")
public class HomeController {

    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setUpCart(){
        return new Cart();
    }

    @GetMapping()
    public ModelAndView getHomePage() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("products", productService.getAll());
        return modelAndView;
    }
    @GetMapping("/product/{id}/details")
    public ModelAndView moveToDetailsPage(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("product/details");
        modelAndView.addObject("product", productService.getOne(id));
        return modelAndView;
    }

}