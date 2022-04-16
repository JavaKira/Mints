package com.mints;

import com.mints.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("products")
public class ProductsController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("products", productService.getAll());
        return "products/index";
    }

    @GetMapping("/{name}")
    public String productPage(@PathVariable String name, HttpServletRequest request, Model model) {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }

        model.addAttribute(cart);
        model.addAttribute("product", productService.getByName(name));
        return "products/product";
    }

    @PostMapping("/{name}")
    public String addProduct(@PathVariable String name, Model model, HttpServletRequest request) {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }

        cart.addProduct(productService.getByName(name));
        return productPage(name, request, model);
    }

    @DeleteMapping("/{name}")
    public String removeProduct(@PathVariable String name, Model model, HttpServletRequest request) {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }

        cart.removeProduct(productService.getByName(name));
        return productPage(name, request, model);
    }
}
