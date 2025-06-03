package com.aishwarya.SpringBoot_SplitWise_2.Exceptions;

public class MemberAlreadyExistsException extends Exception {
    public MemberAlreadyExistsException(String message) {
        super(message);
    }
}
