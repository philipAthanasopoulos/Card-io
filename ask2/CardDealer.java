
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CardDealer {
    private Scanner input = new Scanner(System.in);
    CardDeck cardDeck;
    final String ANSI_RESET = "\u001B[0m";
    final String ANSI_YELLOW = "\033[0;33m";


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
        System.out.println("Creating deck of size "+cardDeck.getCardGroups().size());

        //Initialize all groups with 2 cards
        for(CardGroup group : cardDeck.getCardGroups()){
            group.setNumOfCards(2);
            remainingCards -= 2;
        }

        //Append random num of cards to each group
        while(remainingCards > 0){
            for(CardGroup group : cardDeck.getCardGroups()){
               Random random = new Random();
               int cardsToAdd = random.nextInt(remainingCards + 1) ;
               group.setNumOfCards(group.getNumOfCards() + cardsToAdd);
               remainingCards -= cardsToAdd;
               if(remainingCards == 0) break;
               System.out.println(remainingCards);
              
            }
        }

        int groupIndex = 0;
        for(CardGroup group : cardDeck.getCardGroups()){
            group.setGroupNumber(groupIndex);
            groupIndex++;
        }
        
        //Set maxCardsToRemove for each group
        for(CardGroup group : cardDeck.getCardGroups()){
            Random random = new Random();
            int maxCardsToRemove = random.nextInt(group.getNumOfCards()-1) + 1;
            group.setMaxCardsToRemove(maxCardsToRemove);
        }
    }

    public void printCardDeck(){
        for(CardGroup group : cardDeck.getCardGroups()){
            System.out.println("Group " + group.getGroupNumber() +" : "+ group.getNumOfCards() + " cards , " + group.getMaxCardsToRemove() + " can be removed each round");
        }
    }

    public void askPlayersMove(Player player){
        if(player instanceof Botaki){
            Botaki botaki = (Botaki) player;
            botaki.calculateBestMove(cardDeck);
            removeCards(botaki.getCardsToRemove(), botaki.getGroupToPlay()) ;
            return;   
        }

        
        System.out.println(player.getName() + " , its your turn");
        System.out.println("Choose a card group : ");
        int groupToRemoveFrom = input.nextInt();
        System.out.println("Choose the number of cards to remove : ");
        int cardsToRemove = input.nextInt();
        // if user gave invalid inputs , ask again
        if(removeCards(cardsToRemove, groupToRemoveFrom) == false) askPlayersMove(player);
    }

    //returns true if user gives valid inputs , false otherwise
    public boolean removeCards(int cardsToRemove , int groupToRemoveFrom){
        for(CardGroup group : cardDeck.getCardGroups()){
            if(group.getGroupNumber() == groupToRemoveFrom){
                if(group.removeCards(cardsToRemove) == false) return false;
                else {
                    System.out.println(ANSI_YELLOW + "removed " + cardsToRemove + " cards from group " + groupToRemoveFrom + ANSI_RESET);
                    return true;
                }
            }
        }
        return false;
    }


    public boolean checkCards( ){
        ArrayList<Integer> indexesToRemove = new ArrayList<Integer>();
        int index = 0;
        //find indexes of groups to remove
        for(CardGroup group : cardDeck.getCardGroups()){
            if(group.getNumOfCards() == 0 ) indexesToRemove.add(index);
            index++;
        }
        //remove them
        for(Integer indexToRemove : indexesToRemove){
            CardGroup groupToRemove = cardDeck.getCardGroups().get(indexToRemove);
            cardDeck.getCardGroups().remove(groupToRemove);
        }
        if(cardDeck.getCardGroups().isEmpty()) {
            return false;
        }
        return true;
    }

    
}
    
    

