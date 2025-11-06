package com.swed.LR8.tasks.exceptions;

public class ScoreFormatException extends MatchParseException {
    public ScoreFormatException(String sa, String sb, Throwable cause) {
        super("Неправильний формат рахунку: [" + sa + "], [" + sb + "]", cause);
    }
}
