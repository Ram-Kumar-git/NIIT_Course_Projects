package com.bej.authenticationservice.filter;

import io.jsonwebtoken.Jwts;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

public class JwtFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;//The servletRequest and servletResponse are cast to HttpServletRequest and HttpServletResponse, respectively.
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse; //This allows access to HTTP-specific features like headers, parameters, etc.
        ServletOutputStream pw = httpServletResponse.getOutputStream();// used to write a response directly to the output stream
        String authHeader = httpServletRequest.getHeader("Authorization");//Retrieves the Authorization header from the request.
        if(authHeader == null || !authHeader.startsWith("Bearer")){
            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            pw.println("Invalid or Missing Token");
            pw.close();
        }
        else{
            String jwtToken = authHeader.substring(7);//removes the bearer part from token
            String userName = Jwts.parser().setSigningKey("secretKey").parseClaimsJws(jwtToken).getBody().getSubject();//code parses the JWT, validates it with a secret key, and extracts the username (subject) from its claims for further use
            httpServletRequest.setAttribute("userName",userName); //can be accessed later in the application, such as in controller methods
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }
}
