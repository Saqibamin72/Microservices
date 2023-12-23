package com.dailycodebuffer.springbootdemo.error;

import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapAutoConfiguration;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(String message){
        super(message);
    }
}
