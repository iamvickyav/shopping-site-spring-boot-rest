package com.madhan.shopping.controller;

import com.madhan.shopping.CustomerInfo;
import com.madhan.shopping.reference.ProductResponse;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerInfoController {

    // Bad Approach as password & other stuffs can be cached in URL history
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    // @GetMapping("/register")
    public List<ProductResponse> test(@RequestParam(value = "name") String name,
                                      @RequestParam(value = "age") String age,
                                      @RequestParam(value = "email") String email,
                                      @RequestParam(value = "PAN") String pan,
                                      @RequestParam(value = "password") String password) {
        return new ArrayList<>();
    }

    @RequestMapping(value = "/customer/register", method = RequestMethod.POST)
    // @PostMapping(value = "/customer/register")
    public List<ProductResponse> registerCustomer(@Valid @RequestBody CustomerInfo customerInfo) {
        System.out.println(customerInfo.getEmail() + " " + customerInfo.getName() +
                " " + customerInfo.getPassword());
        return new ArrayList<>();
    }

}
