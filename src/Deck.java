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

    public int deckSize(){
        return this.cards.size();
    }

    public void returnCards2Deck(Deck moveTo){
        int thisDeckSize = this.cards.size();
        for(int i = 0; i < thisDeckSize; i++){
            moveTo.addCard(this.getCard(i));
        }
        for (int i = 0; i < thisDeckSize; i++){
            this.removeCard(0);
        }
    }

    public int cardsValue(){
        int totalValue = 0;
        int aces = 0;

        for (Card card : this.cards){
            switch (card.getValue()){
                case TWO: totalValue += 2; break;
                case THREE: totalValue += 3; break;
                case FOUR: totalValue += 4; break;
                case FIVE: totalValue += 5; break;
                case SIX: totalValue += 6; break;
                case SEVEN: totalValue += 7; break;
                case EIGHT: totalValue += 8; break;
                case NINE: totalValue += 9; break;
                case TEN: totalValue += 10; break;
                case JACK: totalValue += 10; break;
                case QUEEN: totalValue += 10; break;
                case KING: totalValue += 10; break;
                case ACE: aces += 1; break;
            }
            for(int i = 0; i < aces; i++){
                if(totalValue > 10){
                    totalValue += 1;
                } else {
                    totalValue += 11;
                }
            }
        }

        return totalValue;
    }
}
