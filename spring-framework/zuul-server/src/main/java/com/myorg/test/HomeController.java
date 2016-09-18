package com.myorg.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Date;

/**
 * Created by Emilio on 18/02/2016.
 */
@RestController
@RequestMapping("/home")
public class HomeController {
    @RequestMapping("/test")
    public String testMethod() {
        return "Hello World from Zuul! " + new Date();
    }

    @RequestMapping("/principal")
    public Principal getPrincipal(Principal principal){
        return principal;
    }

}
