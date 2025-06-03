package com.aishwarya.SpringBoot_SplitWise_2.Exceptions;

public class UnAuthorizedAccessException extends Exception{
    public UnAuthorizedAccessException(String message) {
        super(message);
    }
}
