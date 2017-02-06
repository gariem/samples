package org.warmilab.codeconf.product;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by Emilio on 31/03/2016.
 */
@RestController
@RequestMapping("/home")
public class HelloWorldController {

    @Value("${property1.childProperty1}")
    private String someProperty;

    @RequestMapping("/helloworld")
    public String helloWorldMethod() {
        return "Hello  from Products Server! " + new Date() + " // Property Valye: " + someProperty;
    }
}
