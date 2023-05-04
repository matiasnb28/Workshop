package com.example.PersonalWorkshop.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CustomExceptionDetails {
    private String exception;
    private String message;
    private String path;

    public CustomExceptionDetails(Exception e, String path){
        this.exception = e.getClass().getSimpleName();
        this.message = e.getMessage();
        this.path = path;
    }

    @Override
    public String toString() {
        return "{" +
                " exception='" + getException() + "'" +
                ", message='" + getMessage() + "'" +
                ", path='" + getPath() + "'" +
                "}";
    }
}
