package com.mints;

import com.mints.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public String getIndexPage(Model model) {
        model.addAttribute("products", productService.getAll());
        return "index";
    }
}
