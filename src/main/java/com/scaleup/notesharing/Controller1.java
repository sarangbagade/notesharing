package com.scaleup.notesharing;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dev_test")
public class Controller1 {

    @GetMapping("/")
    public String hello()
    {
        return "hello world";
    }
}
