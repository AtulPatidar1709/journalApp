//package net.engineeringdigest.journalApp.service;
//
//import net.engineeringdigest.journalApp.entity.User;
//import net.engineeringdigest.journalApp.repository.UserRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.ArgumentMatchers;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//
//import static org.mockito.Mockito.*;
//
//public class UserDetailsServiceIMPLTests {
//
//    @InjectMocks
//    private UserDetailsServiceIMPL userDetailsServiceIMPL;
//
//    @Mock
//    private UserRepository userRepository;
//
//    @BeforeEach
//    void setUp(){
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    void loadUserNameUsernameTest(){
//
//        when(userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn(User.builder().userName("Atul").password("Atul").roles(new ArrayList<>()).build());
//        UserDetails user = userDetailsServiceIMPL.loadUserByUsername("Atul");
//        Assertions.assertNotNull(user);
//    }
//}
