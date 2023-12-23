package com.saqib.user.UserService.exception;

public class ResourceNotFoundException extends  RuntimeException{
    public ResourceNotFoundException(){
        super("resource Not found!!");
    }
    public  ResourceNotFoundException(String message){
        super(message);
    }
}
