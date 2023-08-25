package com.example.apigateway.fallback;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

    @GetMapping("/securityFallback")
    public String securityFallback(){
        return "Security service is currently unavailable. Please try again later.";
    }

    @GetMapping("/userFallback")
    public String userFallback(){
        return "User service is currently unavailable. Please try again later.";
    }

}
