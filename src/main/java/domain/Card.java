package domain;

import java.security.InvalidParameterException;

public class Card {

    private final CardFace face;
    private final CardType type;
    private final int value;

    public Card(CardFace face, CardType type, int value) {

        if (value < 1 || value > 10) {
            throw new InvalidParameterException("invalid card value");
        }

        if (!face.isNone() && value != 10) {
            throw new InvalidParameterException("invalid card value");
        }

        this.face = face;
        this.type = type;
        this.value = value;
    }

    public Card(CardFace face, CardType type) {
        this(face, type, 10);
    }

    public boolean isAce() {
        return face.isNone() && type.isSpade() && value == 1;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        if (face.isNone()) {
            return value + type.getName();
        }
        return face.getName() + type.getName();
    }

}