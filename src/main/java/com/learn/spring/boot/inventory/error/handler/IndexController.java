package com.learn.spring.boot.inventory.error.handler;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;

/**
 * Handling white page error where wrong path is entered 
 * @author Nitish
 * @ApiIgnore: Used to ignore exposing all api from this controller via swagger
 *
 */
@ApiIgnore
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
        return "No service found for specified path";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
