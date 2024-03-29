package com.my.ddl.schema.config;

import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

@Getter
@ToString
public class Jwt {

   @Value("${security.jwt.uri:/auth/login/**}")
   private String Uri;

   @Value("${security.jwt.uri.web:/auth/login/**}")
   private String UriWebClient;

   @Value("${security.jwt.header:Authorization}")
   private String header;

   @Value("${security.jwt.prefix:Bearer }")
   private String prefix;

   @Value("${security.jwt.expiration:#{24*60*60}}")
   private int expiration;

   @Value("${security.jwt.secret:JwtSecretKey}")
   private String secret;
}
