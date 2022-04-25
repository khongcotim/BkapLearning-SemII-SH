package com.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/cart.html")
public class CartController {

    @RequestMapping("")
    public String cart(){
        return "WEB-INF/views/client/pages/cart";
    }
}
