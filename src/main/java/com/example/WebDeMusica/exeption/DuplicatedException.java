package com.example.WebDeMusica.exeption;

public class DuplicatedException extends RuntimeException{
    public DuplicatedException(String message) {
        super(message);
    }
}