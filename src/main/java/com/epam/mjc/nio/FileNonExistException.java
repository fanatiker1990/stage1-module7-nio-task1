package com.epam.mjc.nio;


public class FileNonExistException extends RuntimeException {
    public FileNonExistException() {
        super("Не верный путь к файлу или не существует");
    }
}