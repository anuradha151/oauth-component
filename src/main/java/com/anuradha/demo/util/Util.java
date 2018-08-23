package com.anuradha.demo.util;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.servlet.http.Cookie;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Util {
    private final static String ALPHABET = "01F2GFF34h56789ABCDEFGHIJKLMNOPQRSTUVWXYZab1defg4hijkl5mnopqrstuvwxyz";
    private final static String KEY = "PBKDF2WithHmacSHA1";
    private final static int ITERATIONS = 10000;
    private final static int KEY_LENGTH = 256;
    private final Random RANDOM = new SecureRandom();
    public String generatedUUID;

    {
        UUID.randomUUID().toString().replaceAll("-", "");
    }

    private String generateRandomString(int length) {
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            stringBuilder.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return new String(stringBuilder);
    }

    public String getSalt(int length) {
        return generateRandomString(length);

    }

    public byte[] hash(char[] password, byte[] salt) {
        PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
        Arrays.fill(password, Character.MIN_VALUE);
        try {
            SecretKeyFactory instance = SecretKeyFactory.getInstance(KEY);
            return instance.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError();
        } catch (InvalidKeySpecException e) {
            throw new AssertionError();
        } finally {
            spec.clearPassword();
        }
    }

    public String getEncPassword(String password, String salt) {
        return new String(hash(password.toCharArray(), salt.getBytes()));
    }

    public String  createJWT(String userId, String key, String role) {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, 1);
        JwtBuilder jwtBuilder = Jwts.builder()
                .setId(userId)
                .setIssuedAt(new Date())
                .setSubject(role)
                .signWith(SignatureAlgorithm.HS256, key)
                .setExpiration(instance.getTime());
        return jwtBuilder.compact();
    }

    public String getFullDate() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public String getCookies(Cookie[] cookies, String name) {
        if (cookies == null)
            return "";
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(name)) {
                return cookie.getValue();
            }
        }
        return "";
    }


}
