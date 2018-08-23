package com.anuradha.demo.util;


import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class Validation {
    public boolean isValidEmail(String email){
        try {
            new InternetAddress(email).validate();
        } catch (AddressException e) {
            return false;
        }
        return true;
    }

//    create password encryption method

}
