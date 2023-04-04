
import java.util.Random;
import java.util.Scanner;
public class CardDealer {
    private Scanner input = new Scanner(System.in);
    CardDeck cardDeck;

    public void requestCardDeck(){
        System.out.println("Please give me the number of cards");
        int numOfCards = input.nextInt();
        System.out.println("Please give me the number of cards");
        int numOfGroups = input.nextInt();
        createCardDeck(numOfCards,numOfGroups);
    }

    

    public void createCardDeck(int numOfCards , int numOfGroups){


        if(numOfCards < numOfGroups*2) requestCardDeck(); // Deck impossible to create , ask again

        cardDeck = new CardDeck(numOfCards, numOfGroups);
        int remainingCards = numOfCards;
        System.out.println(cardDeck.cardGroups.size());

        //Initialize all groups with 2 cards
        for(CardGroup group : cardDeck.cardGroups){
            group.setNumOfCards(2);
            remainingCards -= 2;
        }

        //Append random num of cards to each group
        while(remainingCards > 0){
            for(CardGroup group : cardDeck.cardGroups){
                Random random = new Random();
               int cardsToAdd = random.nextInt(remainingCards+1);
               remainingCards -= cardsToAdd;
               group.setNumOfCards(group.getNumOfCards() + cardsToAdd);
            }
        }
        
        //Create maxCardsToRemove for each group
        for(CardGroup group : cardDeck.cardGroups){
            Random random = new Random();
            int maxCardsToRemove = random.nextInt(group.getNumOfCards());
            if(maxCardsToRemove == 0) maxCardsToRemove = 1; // in case of bad luck
            group.setMaxCardsToRemove(maxCardsToRemove);
        }

    }

    public void printCardDeck(){
        for(CardGroup group : cardDeck.cardGroups){
            int i = 1;
            System.out.println("Group" + i +" : "+ group.getNumOfCards() + " cards , " + group.getMaxCardsToRemove() + " can be removed each round");
            i++;
        }
    }
    
}
    
    

