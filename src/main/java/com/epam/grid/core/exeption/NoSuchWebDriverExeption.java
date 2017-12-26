package com.epam.grid.core.exeption;

public class NoSuchWebDriverExeption extends RuntimeException {
    public NoSuchWebDriverExeption(String message){
        super(message);
    }
}
