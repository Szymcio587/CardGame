public class Card
{
    private Color color;
    private Value value;
    private String path;
    enum Color
    {
        S, H, D, C;

        private static final Color[] colors = Color.values();
        public static Color getColor(int i)
        {
            return Color.colors[i];
        }
    }
    enum Value {
        N, T, J, Q, K, A;
        private static final Value[] values = Value.values();

        private static final Value[] value = Value.values();

        public static Value getValue(int i)
        {
            return Value.value[i];
        }
    }



    public Card(final Color color, final Value value)
    {
        this.color = color;
        this.value = value;
        this.path = "Classic/" + value + color + ".png";
    }

    public String getPath() {
        return path;
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
