package statistics;

import java.util.*;
import statistics.matcher.*;

public class QueryBuilder {

    private List<Matcher> lista;

    public QueryBuilder() {
        lista = new ArrayList<>();
    }

    public Matcher build() {
        Matcher[] match = new Matcher[lista.size()];
        for (int i = 0; i < match.length; i++) {
            match[i] = lista.get(i);
        }
        return new And(match);
    }

    QueryBuilder hasAtLeast(Integer number, String matcher) {
        this.lista.add(new HasAtLeast(number, matcher));
        return this;
    }

    QueryBuilder hasFewerThan(Integer number, String matcher) {
        this.lista.add(new HasFewerThan(number, matcher));
        return this;
    }

    QueryBuilder not(Matcher... matcher) {
        this.lista.add(new Not(matcher));
        return this;
    }

    QueryBuilder playsIn(String matcher) {
        this.lista.add(new PlaysIn(matcher));
        return this;
    }

    QueryBuilder oneOf(Matcher... matchers) {
        this.lista.add(new Or(matchers));
        return this;
    }
}
