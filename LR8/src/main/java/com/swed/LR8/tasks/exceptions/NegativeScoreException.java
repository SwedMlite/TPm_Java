package com.swed.LR8.tasks.exceptions;

public class NegativeScoreException extends MatchParseException {
    public NegativeScoreException(int pa, int pb) {
        super("Негативний рахунок: " + pa + ":" + pb);
    }
}
