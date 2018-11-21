import java.util.ArrayList;
import java.util.Random;

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

    public void shuffle(){
        ArrayList<Card> tempDeck = new ArrayList<Card>();
        Random random = new Random();
        int randomCardIndex = 0;
        final int originalSize = this.cards.size();
        for(int i = 0; i < originalSize; i++){
            randomCardIndex = random.nextInt(this.cards.size());
            tempDeck.add(this.cards.get(randomCardIndex));
            this.cards.remove(randomCardIndex);
        }

        this.cards = tempDeck;
    }

    public String toString(){
        String cardListOutput = "";
        for(Card card : this.cards){
            cardListOutput += "\n" + " " + card.toString();
        }
        return cardListOutput;
    }

    public void removeCard(final int i){
        this.cards.remove(i);
    }

    public Card getCard(final int i){
        return this.cards.get(i);
    }

    public void addCard(Card card){
        this.cards.add(card);
    }

    public void draw(Deck comingFrom){
        this.cards.add(comingFrom.getCard(0));
        comingFrom.removeCard(0);
    }
}
