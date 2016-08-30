package com.demo.security.myFilter;

import java.io.IOException;

import org.springframework.security.authentication.encoding.PasswordEncoder;

import sun.misc.BASE64Decoder;

import com.demo.security.utils.MD5Utils;

public class Md5PasswordEncoderExt implements PasswordEncoder {

    @Override
    public String encodePassword(String rawPass, Object salt) {
        return MD5Utils.encrypt(rawPass,String.valueOf(salt));
    }

    @Override
    public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
        String password = null;
        try {
            password = new String(new BASE64Decoder().decodeBuffer(rawPass));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(encPass.equals(MD5Utils.encrypt(rawPass, String.valueOf(salt)))){
            return true;
        }
        return false;
    }
}