package com.bej.authenticationservice.service;

import com.bej.authenticationservice.domain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtSecurityTokenGeneratorImpl implements SecurityTokenGenerator{

    @Override
    public Map<String,String> generateToken(User user){
        String jwtToken = null;

        jwtToken = Jwts.builder() //creates new jwt builder
                .setSubject(user.getUserName())//store unique user id
                .setIssuedAt(new Date()) //adds token creation time
                .signWith(SignatureAlgorithm.HS256,"secretKey").compact(); //secure this key to ensure security

        Map<String,String> map = new HashMap<>();
        map.put("token",jwtToken);
        map.put("message","User logged in successfully");
        return map;
    }
}
