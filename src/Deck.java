import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> cards;

    public Deck(){
        this.cards = new ArrayList<Card>();
    }

    public void createDeck(){
        for (Suit cardSuit : Suit.values()){
            for(Value cardValue : Value.values()){
                this.cards.add(new Card(cardSuit, cardValue));
            }
        }
    }

    public String toString(){
        String cardListOutput = "";
        int i = 0;
        for(Card card : this.cards){
            cardListOutput += "\n" + i + " " + card.toString();
            i++;
        }
        return cardListOutput;
    }
}
