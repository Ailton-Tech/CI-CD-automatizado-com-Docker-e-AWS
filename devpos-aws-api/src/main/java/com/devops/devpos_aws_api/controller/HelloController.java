package com.devops.devpos_aws_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController
{
    @GetMapping("/hello")
    public String Hello(){
        return "olá Minha API Devops aws está funcionando!";

}
}

