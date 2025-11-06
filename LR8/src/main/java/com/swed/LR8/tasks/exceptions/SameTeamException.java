package com.swed.LR8.tasks.exceptions;

public class SameTeamException extends MatchParseException {
    public SameTeamException(String a) { super("Команда не може грати сама із собою: " + a); }
}
