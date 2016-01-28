package com.myorg.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by Garcia Rios, Emilio R on 1/23/2016.
 */
@RestController
@RequestMapping("/home")
public class HomeController {

    @RequestMapping("/test")
    public String testMethod() {
        return "Hello World! " + new Date();
    }
}
