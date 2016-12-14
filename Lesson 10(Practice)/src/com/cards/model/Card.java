package com.cards.model;

/**
 * Created by denis.selutin on 04.11.2016.
 */
public interface Card  {

    Type getType();

    int getValue();

    SubType getSubType();

    enum Type {
        COMMON, UNCOMMON, JOKER;
    }

    enum SubType {
        HEART, DIAMOND, CLUB, SPADE;

    }
}
