package com.bej.authenticationservice.repository;

import com.bej.authenticationservice.domain.User;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    private User user;



    @BeforeEach
    void setUp(){
        user = new User(1,"Ram","Pass@123","Chennai");
    }





    @AfterEach
    void tearDown(){
        user = null;
        userRepository.deleteAll();
    }

    @Test



    @DisplayName("Test case for saving user object")


    void givenUserToSaveAndReturnUser(){
        userRepository.save(user);
        User user1 = userRepository.findById(user.getUserId()).get();
        assertNotNull(user1);
        assertEquals(user.getUserId(),user1.getUserId());
    }

    @Test
    @DisplayName("Test case for deleting user object")
    void givenUserToDeleteShouldDeleteUser(){
        userRepository.save(user);
        User user1 = userRepository.findById(user.getUserId()).get();
        userRepository.delete(user1);
        assertEquals(Optional.empty(),userRepository.findById(user.getUserId()));
    }

    @Test
    @DisplayName("Test case for fetching user list")
    void givenUserReturnGetAllUser(){
        userRepository.save(user);
        User user1 = new User(2,"Kumar","Pass@234","Hyderabad");
        userRepository.save(user1);
        List<User> userList = userRepository.findAll();
        assertEquals(2,userList.size());
        assertEquals("Kumar",userList.get(1).getUserName());
    }





}
