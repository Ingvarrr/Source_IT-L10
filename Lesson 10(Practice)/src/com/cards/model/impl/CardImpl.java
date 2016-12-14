package com.cards.model.impl;

import com.cards.model.Card;

/**
 * Created by denis.selutin on 04.11.2016.
 */
public class CardImpl implements Card {
    private Type type;
    private int value;
    private SubType subType;

    public CardImpl(Type type, int value, SubType subType) {
        this.type = type;
        this.value = value;
        this.subType = subType;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public SubType getSubType() {
        return subType;
    }

    @Override
    public String toString() {
        return "{" + type+", "+subType+","+value+"}";
    }
}
