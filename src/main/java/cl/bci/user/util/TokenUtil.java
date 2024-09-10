package cl.bci.user.util;

import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

public class TokenUtil {

    @Value("${signature.algorithm}")
    private static String signature;


    public static String generateToken(String email, String nombre){

        JwtBuilder myBuilder = Jwts.builder();
        myBuilder.setHeaderParam(JwsHeader.TYPE,JwsHeader.JWT_TYPE);
        myBuilder.setHeaderParam(JwsHeader.ALGORITHM, signature);
        myBuilder.setHeaderParam(JwsHeader.KEY_ID,"1");
        myBuilder.setSubject(email);
        myBuilder.claim("name", nombre);

        String jwtToken = myBuilder.compact();

        return jwtToken;


    }

    public static void main(String[] args) {
        System.out.println(TokenUtil.generateToken("email@email.com", "nombre"));
    }







}
