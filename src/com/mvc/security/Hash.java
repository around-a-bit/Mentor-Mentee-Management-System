package com.mvc.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

  public String hashString(String message) throws NoSuchAlgorithmException {
    MessageDigest md = MessageDigest.getInstance("MD5");
    md.update(message.getBytes());
    byte[] digest = md.digest();

    StringBuilder sb = new StringBuilder();
    for (byte b : digest) {
      sb.append(String.format("%02x", b));
    }
    return sb.toString();
  }
}