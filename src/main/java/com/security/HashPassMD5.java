package com.security;

import lombok.Data;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Data
public class HashPassMD5 {

    public String toMD5(String password){
        String generatedPass = null;
        try
        {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Add password bytes to digest
            md.update(password.getBytes());

            // Get the hash's bytes
            byte[] bytes = md.digest();

            // This bytes[] has bytes in decimal format. Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            // Get complete hashed password in hex format
            generatedPass = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPass;
    }

    public Boolean verifyMD5(String hashedPass,String passNeedCompare) {
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(passNeedCompare.getBytes());
            byte[] digest = md.digest();
            // Note here that I use a StringBuilder instead of a StringBuffer
            // as it is not meant to be shared so no need to use a thread safe
            // builder of String
            StringBuilder sb = new StringBuilder(32);
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            if (hashedPass.equals(sb.toString()))
                return true;
            else
                return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
}
