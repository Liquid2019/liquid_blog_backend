package com.liquid;

import io.jsonwebtoken.*;

import java.util.Date;
import java.util.UUID;

public class Test {

    private long time=1000*60*60*24;
    private String signature="admin";

    @org.junit.Test
    public void jwt(){
        JwtBuilder jwtBuilder= Jwts.builder();
        String jwtToken=jwtBuilder
                //header
                .setHeaderParam("typ","JWT")
                .setHeaderParam("alg","HS256")
                //payload
                .claim("username","tom")
                .claim("role","admin")
                .setSubject("admin-test")
                .setExpiration(new Date(System.currentTimeMillis()+time))
                .setId(UUID.randomUUID().toString())
                //signature
                .signWith(SignatureAlgorithm.HS256,signature)
                .compact();
        System.out.println(jwtToken);
    }

    @org.junit.Test
    public void parse(){
        String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6InRvbSIsInJvbGUiOiJhZG1pbiIsInN1YiI6ImFkbWluLXRlc3QiLCJleHAiOjE2MzQ4MTgyMzMsImp0aSI6ImUzMGFiMjlmLWEyYjMtNGY5Yi1hMmJkLTY3OTIyNTMxOGYwNCJ9.-mKLBtLRjsOEB1HuSBmzSfVtHWkPJw2HySvhU9lGIFs";
        JwtParser jwtParser=Jwts.parser();
        Jws<Claims> claimsJws = jwtParser.setSigningKey(signature).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        System.out.println(claims.get("username"));
        System.out.println(claims.get("role"));
        System.out.println(claims.getId());
        System.out.println(claims.getSubject());
        System.out.println(claims.getExpiration());
    }
}
