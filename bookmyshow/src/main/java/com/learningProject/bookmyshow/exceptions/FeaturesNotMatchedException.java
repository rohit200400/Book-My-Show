package com.learningProject.bookmyshow.exceptions;

public class FeaturesNotMatchedException extends Exception{
    public FeaturesNotMatchedException() {
    }

    public FeaturesNotMatchedException(String message) {
        super(message);
    }

    public FeaturesNotMatchedException(String message, Throwable cause) {
        super(message, cause);
    }

    public FeaturesNotMatchedException(Throwable cause) {
        super(cause);
    }

    public FeaturesNotMatchedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
