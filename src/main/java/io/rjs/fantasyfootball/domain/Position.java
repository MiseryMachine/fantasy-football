package io.rjs.fantasyfootball.domain;

public enum Position {
    QB("QB"),
    RB("RB"),
    WR("WR"),
    TE("TE"),
    K("K"),
    DEF("DEF");

    public final String text;

    Position(String text) {
        this.text = text;
    }
}
