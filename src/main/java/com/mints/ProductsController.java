package com.mints;

import com.mints.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("products")
public class ProductsController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public String index(Model model)
    {
        model.addAttribute("products", productService.getAll());
        return "products/index";
    }
}
