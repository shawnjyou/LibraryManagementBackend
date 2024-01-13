package com.example.librarymanagement;


import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PasswordHasher {
    public static String hashPassword(String password, String salt) {
        try {
            String passwordWithSalt = password + salt;
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(passwordWithSalt.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hashedBytes);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}