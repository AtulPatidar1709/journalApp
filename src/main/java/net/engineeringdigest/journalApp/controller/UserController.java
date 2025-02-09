package net.engineeringdigest.journalApp.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import net.engineeringdigest.journalApp.api.response.WeatherResponse;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepository;
import net.engineeringdigest.journalApp.service.UserService;
import net.engineeringdigest.journalApp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
@Tag(name = "User APIs", description = "Read, Update and Delete User")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private WeatherService weatherService;


    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();

        User byUserName = userService.findByUserName(userName);

        byUserName.setUserName(user.getUserName());
        byUserName.setPassword(user.getPassword());
        userService.saveNewUser(byUserName);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping()
    public ResponseEntity<?> deleteUserById(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userRepository.deleteByUserName(authentication.getName());

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping()
    public ResponseEntity<?> greeting(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        WeatherResponse weatherResponse = weatherService.getWeather("Indore");
        String greetings = "";
        if (weatherResponse != null){
            greetings =  ", Weather feels like " + weatherResponse.getCurrent().getFeelslike() + "C";
        }
        return new ResponseEntity<>("Hi " + authentication.getName() + greetings ,HttpStatus.OK);
    }

}