package com.codegym.controller;

import com.codegym.model.Bill;
import com.codegym.model.Cart;
import com.codegym.model.CartProduct;
import com.codegym.model.Customer;
import com.codegym.model.Product;
import com.codegym.service.cart.ICartService;
import com.codegym.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@SessionAttributes("cart")

public class CartRestController {

    @Autowired
    private ICartService cartService;

    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setUpCart() {
        return new Cart();
    }

    //    @RequestMapping(value = "/carts", method = RequestMethod.POST,
//            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public Classes createClasses(@RequestBody Classes classes) {
//        classesService.save(classes);
//        return classes;
//    }
    @PostMapping("/carts")
    public ResponseEntity<String> addToCart(@RequestBody Product product, @ModelAttribute("cart") Cart cart) {
        List<Product> products = cart.getProducts();
        boolean isProductExist = cartService.isExists(product.getId(), products);
        if (isProductExist) {
            Product product1 = cartService.findOne(product.getId(), products);
            product1.setQuantity(product1.getQuantity() + product.getQuantity());
        } else {
            products.add(product);
            System.out.println(products.get(0).getId());
        }
        int totalQuantity = cartService.getTotalQuantity(products);
        cart.setTotalQuantity(totalQuantity);
        float totalPrice = cartService.getTotalPrice(products);
        cart.setTotalPrice(totalPrice);
        return new ResponseEntity<>(String.valueOf(totalQuantity), HttpStatus.OK);
    }

    @DeleteMapping("/carts/{id}")
    public ResponseEntity<Bill> removeProduct(@PathVariable("id") Long id, @ModelAttribute("cart") Cart cart) {
        List<Product> products = cart.getProducts();
        boolean isProductExist = cartService.isExists(id, products);
        if (isProductExist) {
            cartService.remove(id, products);
            int totalQuantity = cartService.getTotalQuantity(products);
            cart.setTotalQuantity(totalQuantity);
            float totalPrice = cartService.getTotalPrice(products);
            cart.setTotalPrice(totalPrice);
            Bill bill = new Bill(totalQuantity, totalPrice);
            return new ResponseEntity<>(bill, HttpStatus.OK);
        } else {
            System.out.println("Unable to delete. Customer with id " + id + "not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}