public class BlackJack {

    public static void main(String[] args){

        System.out.println("Welcome to BlackJack!");

        Deck playingDeck = new Deck();
        playingDeck.createDeck();

        System.out.println(playingDeck);
    }
}
