package com.igreendata.user.exception;

import lombok.Getter;

@Getter
public class TransactionsException extends RuntimeException  {

    public TransactionsException(String message) {
        super(message);
    }

    public TransactionsException(String message, Throwable cause) {
        super(message, cause);
    }
}
