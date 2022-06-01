package com.peerlearn.peerlearn.security.filters;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.peerlearn.peerlearn.constants.Routes;
import com.peerlearn.peerlearn.errors.exceptions.NotValidTokenException;
import com.peerlearn.peerlearn.modules.user.dtos.UserTokenPayloadDto;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;

@Component
public class TokenAuthFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println(" TokenAuthFilter  doFilterInternal()");
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256("secret"))
                //.withIssuer("auth0")
                .build(); //Reusable verifier instance
        String bearer = request.getHeader("Authorization");
        if(bearer == null || !bearer.startsWith("Bearer ")){
            throw new NotValidTokenException("Token is not in the correct format");
        }
        DecodedJWT jwt = verifier.verify(bearer.split(" ")[1].trim());
        UserTokenPayloadDto payloadDto = new ObjectMapper().readValue(Base64.getDecoder().decode(jwt.getPayload()),UserTokenPayloadDto.class);
        request.setAttribute("token-payload",payloadDto);
        filterChain.doFilter(request,response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return Arrays.stream(Routes.PUBLIC_ROUTES).anyMatch(r -> r.equals(request.getRequestURI()));
    }
}
