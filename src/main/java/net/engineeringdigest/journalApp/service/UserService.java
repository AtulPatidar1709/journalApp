package net.engineeringdigest.journalApp.service;

import ch.qos.logback.core.encoder.EchoEncoder;
import lombok.extern.slf4j.Slf4j;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Component
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void saveUser(User user){
        userRepository.save(user);
    }

    public boolean saveNewUser(User user){
        try{
            user.setPassword(passwordEncoder.encode(user.getPassword()));

            // Assign the default role "USER"
            user.setRoles(Arrays.asList("USER")); // Set the roles in the user object

            userRepository.save(user);

            return true;

        } catch (Exception e){
            log.error("Please Enter correct Details");
            return false;
        }
    }

    public void saveAdmin(User user){
        // Assign the default role "USER"
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        user.setRoles(Arrays.asList("USER", "ADMIN")); // Set the roles in the user object

        userRepository.save(user);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(ObjectId id){
        return userRepository.findById(id);
    }

    public void deleteById(ObjectId id){
        userRepository.deleteById(id);
    }

    public User findByUserName(String userName){
        return userRepository.findByUserName(userName);
    }



}
