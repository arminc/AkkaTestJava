package com.xebia.messages.hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CalculateHash {

    public void calculate(String text) {
        createHash(getMessageDigest(), text);
    }

    private MessageDigest getMessageDigest() {
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.reset();
            return m;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("No MD5");
        }
    }

    private void createHash(MessageDigest md, String text) {
        md.update(text.getBytes());
        md.digest();
    }
}
