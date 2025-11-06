package com.swed.LR8.tasks;

import com.swed.LR8.tasks.exceptions.*;

final class MatchParser {
    Match parse(String line) throws MatchParseException {
        String[] parts = line.split(":");
        if (parts.length != 4) throw new MalformedLineException(line);

        String a  = parts[0].trim();
        String b  = parts[1].trim();
        String sa = parts[2].trim();
        String sb = parts[3].trim();

        if (a.isEmpty() || b.isEmpty() || sa.isEmpty() || sb.isEmpty()) {
            throw new MissingFieldException();
        }
        if (a.equals(b)) throw new SameTeamException(a);

        final int pa, pb;
        try {
            pa = Integer.parseInt(sa);
            pb = Integer.parseInt(sb);
        } catch (NumberFormatException nfe) {
            throw new ScoreFormatException(sa, sb, nfe);
        }
        if (pa < 0 || pb < 0) throw new NegativeScoreException(pa, pb);

        return new Match(a, b, pa, pb);
    }
}
