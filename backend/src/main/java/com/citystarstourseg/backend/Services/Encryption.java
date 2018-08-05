package com.citystarstourseg.backend.Services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class Encryption {

    private String level;

    public Encryption(String level) {
        switch (level) {
            case "easy":
                this.level = "SHA-1";
                break;
            case "medium":
                this.level = "SHA-256";
                break;
            case "hard":
                this.level = "SHA-512";
                break;
            default:
                this.level = "SHA-512";
                break;
        }

    }

    private byte[] getSalt() throws NoSuchAlgorithmException {
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);
        return salt;
    }

    public String[] encrypt(String password, byte[] salt) throws NoSuchAlgorithmException {
        String passwordHash = null;
        if(salt == null)
            salt = getSalt();
        try {
            MessageDigest md = MessageDigest.getInstance(level);
            md.update(salt);
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            passwordHash = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        String saltString = new String(salt);
//        String saltString = Base64.getEncoder().encodeToString(salt);
        String[] returnedArray = new String[2];
        returnedArray[0] = saltString;
        returnedArray[1] = passwordHash;
        return returnedArray;
    }


}
