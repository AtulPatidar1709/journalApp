package net.engineeringdigest.journalApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealtCheck {

    @GetMapping("check")
    public String check(){
        return "Ok";
    }
}
