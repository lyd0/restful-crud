package com.edmar.restfulcrud.exception;

public class UserNotFound extends RuntimeException{
    public UserNotFound() {
        super("用户不存在！");
    }
}

