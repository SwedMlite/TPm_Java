package com.swed.LR8.tasks.exceptions;

public class MalformedLineException extends MatchParseException {
    public MalformedLineException(String line) { super("Очікувалося 4 частини у рядку: " + line); }
}
