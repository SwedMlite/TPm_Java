package com.swed.LR8.tasks.exceptions;

public class MissingFieldException extends MatchParseException {
    public MissingFieldException() { super("Порожні поля у записі матчу"); }
}
