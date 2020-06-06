package com.scaleup.notesharing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = "/index")
    public String getIndex()
    {
        return "index";
    }

    @RequestMapping(value = "/shop")
    public String getShop(){return "shop";}

}
