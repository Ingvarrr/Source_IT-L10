package com.cards.model.impl;

import com.cards.model.*;
import java.util.Random;

/**
 * Created by vig on 11/4/16.
 */
public class GameService implements Game {
    private Card[] deck;
    private Player[] players = new Player[10];
    private int[] playerScore = new int[10];
    private int currentPlayerNumber = -1;
    private int size;
    private Card lastCard;

    public boolean hasNextCard() {
        return size >= 0;
    }

    @Override
    public void setDeck(Card[] cards) {
        this.deck = cards;
        this.size = cards.length;
    }

    @Override
    public Card[] getDeck() {
        return this.deck;
    }

    @Override
    public void setPlayer(Player player1, int palyerIndex) {
        players[palyerIndex] = player1;
    }

    @Override
    public Player getNextPlayer() {
        if (players[currentPlayerNumber + 1] == null) currentPlayerNumber = -1;
        return players[++currentPlayerNumber];
    }

    @Override
    public Card getNextCard() throws CardException {
        if (size == 0) {
            throw new EmptyDeckException();
        }
        Random random = new Random();
        int randomCard = random.nextInt(size) + 1;
        Card card = deck[randomCard - 1];

        if(card == null) {
            throw new NoCardFoundException();
        }

        for (int i = randomCard - 1; i < size - 1; i++) {
            deck[i] = deck[i + 1];
        }
        deck[size - 1] = null;
        size--;
        return card;

    }

    @Override
    public boolean currentPlayerPlaysCard(Card card) {
        Player current = players[currentPlayerNumber];
        if (lastCard = null) {
            lastCard = card;
        } else if (lastCard.getValue() < card.getValue()) {
            playerScore[currentPlayerNumber]++;
        } else {
            playerScore[currentPlayerNumber]--;
        }
        lastCard = null;
        return false;
    }

    @Override
    public boolean currentPlayerPlaysCard(int cardNumberInThePalyersHand) {
        return false;
    }

    @Override
    public boolean currentPlayerPlaysRandomCard() {
        return false;
    }

    @Override
    public int getPlayersScore(int palyerNumber) {
        return playerScore[palyerNumber];
    }

    @Override
    public int getPlayersScore(Player player) {
        for (int i = 0; i < players.length; i++) {
            Player current = players[i];
            if (player.equals(current)) {
                return playerScore[i];
            }
        }
        return 0;
    }

    @Override
    public void dealCards() {
        for (int i = 0; i < 6; i++) {
            for (Player p : players) {
                if (p != null) {
                    try {
                        p.addCard(getNextCard());
                    } catch (CardException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
