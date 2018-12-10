import java.util.Scanner;

public class BlackJack {

    public static void main(String[] args){

        System.out.println("Welcome to BlackJack!");

        Deck playingDeck = new Deck();
        playingDeck.createDeck();
        playingDeck.shuffle();

        Deck playerDeck = new Deck();
        Deck dealerDeck = new Deck();
        double playerMoney = 1000.00;

        Scanner userInput = new Scanner(System.in);

        //Game Loop
        while (playerMoney > 0){
            System.out.println("You have " + playerMoney + " €, how much would you like to bet?");
            double playerBet = userInput.nextDouble();
            if(playerBet > playerMoney){
                System.out.println("You are too stupid to play!");
                break;
            }

            boolean endRound = false;

            //Start dealing
            playerDeck.draw(playingDeck);
            playerDeck.draw(playingDeck);
            dealerDeck.draw(playingDeck);
            dealerDeck.draw(playingDeck);

            while (true){
                System.out.println("Your hand:");
                System.out.println(playerDeck.toString());
                System.out.println("Your cards value: " + playerDeck.cardsValue());

                System.out.println("Dealer hand: " + dealerDeck.getCard(0).toString() + " [Hidden]");

                System.out.println("Would you like to (1)hit or (2)stand?");
                int response = userInput.nextInt();
                if(response == 1){
                    playerDeck.draw(playingDeck);
                    System.out.println("You draw a: " + playerDeck.getCard(playerDeck.deckSize() - 1).toString());
                    if(playerDeck.cardsValue() > 21){
                        System.out.println("Bust. Current value: " + playerDeck.cardsValue());
                        playerMoney -= playerBet;
                        endRound = true;
                        break;
                    }
                } else if(response == 2){
                    break;
                }
            }

            System.out.println("Dealer cards: " + dealerDeck.toString());
            if(dealerDeck.cardsValue() > playerDeck.cardsValue() && endRound == false){
                System.out.println("You lose. Dealer won");
                playerMoney -= playerBet;
                endRound = true;
            }
            while (dealerDeck.cardsValue() < 17 && endRound == false){
                dealerDeck.draw(playingDeck);
                System.out.println("Dealer draws: " + dealerDeck.getCard(dealerDeck.deckSize() - 1));
            }
            System.out.println("Dealer's hand value: " + dealerDeck.cardsValue());
            if(dealerDeck.cardsValue() > 21 && endRound == false){
                System.out.println("Dealer busts! You win!");
                playerMoney += playerBet;
                endRound = true;
            }
            if(playerDeck.cardsValue() == dealerDeck.cardsValue() && endRound == false){
                System.out.println("Push");
                endRound = true;
            }
            if(playerDeck.cardsValue() > dealerDeck.cardsValue() && endRound == false){
                System.out.println("You win the hand!");
                playerMoney += playerBet;
                endRound = true;
            } else if(endRound == false){
                System.out.println("You lose the hand.");
                endRound = true;
            }
            playerDeck.returnCards2Deck(playingDeck);
            dealerDeck.returnCards2Deck(playingDeck);
            System.out.println("End of hand.");
        }

        System.out.println("Game over!");
        userInput.close();
    }
}
