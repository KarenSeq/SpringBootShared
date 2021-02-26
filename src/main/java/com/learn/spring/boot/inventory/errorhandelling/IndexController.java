package com.learn.spring.boot.inventory.errorhandelling;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handling white page error where wrong path is entered 
 * @author Nitish
 *
 */
@RestController
public class IndexController implements ErrorController{

    private static final String PATH = "/error";

    /**
     * When api with wrong path is invoked, 
     * by default ErrorMvcAutoConfiguration will look for path /error
     * If not found it will show white page error
     * @return
     */
    @RequestMapping(value = PATH)
    public String error() {
        return "No path found";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
