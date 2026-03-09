package com.example.exception;

public class PolicyNotFoundException extends RuntimeException{

public PolicyNotFoundException(String msg){

super(msg);
}
}