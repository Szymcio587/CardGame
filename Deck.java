public class Deck {
    private Card cards[];

    public Deck() {
        cards = new Card[24];
    }

    public void reset() {
        Card.Color[] colors = Card.Color.values();
        Card.Value[] values = Card.Value.values();
        for(int q=0; q<6; q++) {
            Card.Value value = values[q];
            for(int w=0; w<4; w++) {
                Card.Color color = colors[w];
                cards[6*q + w] = new Card(color, value);
            }
        }
    }

    public Card drawCard(int index) {
        return cards[index];
    }
}
