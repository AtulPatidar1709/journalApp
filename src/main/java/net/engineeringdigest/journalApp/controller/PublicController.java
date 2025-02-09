package net.engineeringdigest.journalApp.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import net.engineeringdigest.journalApp.api.response.QuotesResponse;
import net.engineeringdigest.journalApp.dto.UserDto;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.service.QuotesService;
import net.engineeringdigest.journalApp.service.UserDetailsServiceIMPL;
import net.engineeringdigest.journalApp.service.UserService;
import net.engineeringdigest.journalApp.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public")
@Slf4j
@Tag(name = "Public APIs")
@CrossOrigin
public class PublicController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceIMPL userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;


    @Autowired
    private UserService userService;

    @Autowired
    private QuotesService quotesService;

    @GetMapping("/check")
    public String check(){
        String check = "Ok";
        return check;
    }

    @PostMapping("/signup")
    public void signup(@RequestBody UserDto user){
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setUserName(user.getUserName());
        newUser.setPassword(user.getPassword());
        newUser.setSentimentAnalysis(user.isSentimentAnalysis());
        userService.saveNewUser(newUser);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user){
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
            UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUserName());
            String jwtToken = jwtUtil.generateToken(userDetails.getUsername());
            return new ResponseEntity<>(jwtToken, HttpStatus.OK);
        } catch (AuthenticationException e) {
            log.error("Exception occured while create Authentication", e);
            return new ResponseEntity<>("Incorrect userName or password", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/quotes")
    public ResponseEntity<List<QuotesResponse>>getQuotes() {
        List<QuotesResponse> quotesResponse = quotesService.getQuotes();
        return ResponseEntity.ok(quotesResponse);
    }
}
