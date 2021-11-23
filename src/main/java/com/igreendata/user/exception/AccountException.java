package com.igreendata.user.exception;

import lombok.Getter;

@Getter
public class AccountException extends RuntimeException {

    public AccountException(String message) {
        super(message);
    }

    public AccountException(String message, Throwable cause) {
        super(message, cause);
    }
}
