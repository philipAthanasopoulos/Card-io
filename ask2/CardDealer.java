
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import javax.swing.event.TreeModelEvent;
public class CardDealer {
    private Scanner input = new Scanner(System.in);
    CardDeck cardDeck;

    public void requestCardDeck(){
        int numOfCards , numOfGroups;
        System.out.println("Please give me the number of cards");
        numOfCards = input.nextInt();
        System.out.println("Please give me the number of groups");
        numOfGroups = input.nextInt();
        createCardDeck(numOfCards,numOfGroups);
    }

    

    public void createCardDeck(int numOfCards , int numOfGroups){


        if(numOfCards < numOfGroups*2) requestCardDeck(); // Deck impossible to create , ask again

        cardDeck = new CardDeck(numOfCards, numOfGroups);
        int remainingCards = numOfCards;
        System.out.println("Creating deck of size "+cardDeck.cardGroups.size());

        //Initialize all groups with 2 cards
        for(CardGroup group : cardDeck.cardGroups){
            group.setNumOfCards(2);
            remainingCards -= 2;
        }

        //Append random num of cards to each group
        while(remainingCards > 0){
            for(CardGroup group : cardDeck.cardGroups){
               Random random = new Random();
               int cardsToAdd = random.nextInt(remainingCards + 1) ;
               group.setNumOfCards(group.getNumOfCards() + cardsToAdd);
               remainingCards -= cardsToAdd;
               if(remainingCards == 0) break;
               System.out.println(remainingCards);
              
            }
        }
        
        //Set maxCardsToRemove for each group
        for(CardGroup group : cardDeck.cardGroups){
            Random random = new Random();
            int maxCardsToRemove = random.nextInt(group.getNumOfCards()-1) + 1;
            group.setMaxCardsToRemove(maxCardsToRemove);
        }
        //Completly randomize the groups
        Collections.shuffle(cardDeck.cardGroups);

    }

    public void printCardDeck(){
        int i = 0;
        for(CardGroup group : cardDeck.cardGroups){
            System.out.println("Group" + i +" : "+ group.getNumOfCards() + " cards , " + group.getMaxCardsToRemove() + " can be removed each round");
            i++;
        }
    }

    public void askPlayersMove(Player player){
        System.out.println(player.getName() + " , its your turn");
        System.out.println("Choose a card group : ");
        int groupToRemoveFrom = input.nextInt();
        System.out.println("Choose the number of cards to remove : ");
        int cardsToRemove = input.nextInt();
        // if user gave invalid inputs , ask again
        if(removeCards(cardsToRemove, groupToRemoveFrom) == false) removeCards(cardsToRemove, groupToRemoveFrom);
    }

    //returns true if user gives valid inputs , false otherwise
    public boolean removeCards(int cardsToRemove , int indexOfGroupToRemoveFrom){
        CardGroup groupToRemoveFrom = cardDeck.cardGroups.get(indexOfGroupToRemoveFrom);
        return groupToRemoveFrom.removeCards(cardsToRemove);
    }


    public boolean checkCards( ){
        ArrayList<Integer> indexesToRemove = new ArrayList<Integer>();
        int index = 0;
        //find indexes of groups to remove
        for(CardGroup group : cardDeck.cardGroups){
            if(group.getNumOfCards() == 0 ) indexesToRemove.add(index);
            index++;
        }
        //remove them
        for(Integer indexToRemove : indexesToRemove){
            CardGroup groupToRemove = cardDeck.cardGroups.get(indexToRemove);
            cardDeck.cardGroups.remove(groupToRemove);
        }
        if(cardDeck.cardGroups.isEmpty()) {
            return false;
        }
        return true;
    }

    
}
    
    

