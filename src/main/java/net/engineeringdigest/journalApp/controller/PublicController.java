package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.api.response.QuotesResponse;
import net.engineeringdigest.journalApp.api.response.WeatherResponse;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.service.QuotesService;
import net.engineeringdigest.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/public")

public class PublicController {


    @Autowired
    private UserService userService;

    @Autowired
    private QuotesService quotesService;

    @PostMapping("/create-user")
    public void createUser(@RequestBody User user){
        userService.saveNewUser(user);
    }

    @GetMapping("/quotes")
    public ResponseEntity<List<QuotesResponse>>getQuotes() {
        List<QuotesResponse> quotesResponse = quotesService.getQuotes();
        return ResponseEntity.ok(quotesResponse);
    }
}
