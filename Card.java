public class Card {
    enum Color {
        SPADES, CLUBS, DIAMONDS, HEARTS;
        private static final Color[] colors = Color.values();

        public static Color getColor(int i) {
            return Color.colors[i];
        }
    }

    enum Value {
        NINE, TEN, JACK, QUEEN, KING, AS;
        private static final Value[] values = Value.values();

        public static Value getValue(int i) {
            return Value.values[i];
        }
    }

    private Color color;
    private Value value;

    public Card(Color color, Value value) {
        this.color = color;
        this.value = value;
    }

    public Color getColor() {
        return color;
    }

    public Value getValue() {
        return value;
    }
}
