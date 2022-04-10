package com.company;

public class Card
{
    enum Color
    {
        Spades, Hearts, Diamonds, Clubs;

        private static final Color[] colors = Color.values();
        public static Color getColor(int i)
        {
            return Color.colors[i];
        }
    }
    enum Value
    {
        Nine, Jack, Queen, King, Ten, Ase;
    enum Value {
        NINE, TEN, JACK, QUEEN, KING, ACE;
        private static final Value[] values = Value.values();

        private static final Value[] value = Value.values();

        public static Value getValue(int i)
        {
            return Value.value[i];
        }
    }

    private final Color color;
    private final Value value;

    public Card(final Color color, final Value value)
    {
        this.color = color;
        this.value = value;
    }

    public Color getColor()
    {
        return color;
    }

    public Value getValue()
    {
        return value;
    }

    public String toString()
    {
        return color + " " + value;
    }
}
