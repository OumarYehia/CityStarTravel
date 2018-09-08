package com.citystarstourseg.backend.Utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

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

    public List<byte[]> encrypt(String password, byte[] salt) throws NoSuchAlgorithmException {
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

        List<byte[]> returnedList = new ArrayList<>();
        returnedList.add(salt);
        assert passwordHash != null;
        returnedList.add(passwordHash.getBytes());

        return returnedList;
    }


}
