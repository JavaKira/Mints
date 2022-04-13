package com.mints;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("cart")
public class CartController {
    @GetMapping
    public String getIndexPage(Model model, HttpServletRequest request)
    {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null)
        {
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }

        model.addAttribute("cart", cart);
        return "cart";
    }
}
