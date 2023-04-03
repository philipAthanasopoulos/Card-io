import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import java.lang.Math;
public class CardDealer {
    //Total number of Cards that arent in group. Dealer just shares the cards to groups
    private int totalNumOfCards;
    private int numOfGroups;
    private List<CardGroup> groups = new ArrayList<CardGroup>();
    private int randomNumber;
    private int groupSize=0;
    private int remainingCards;
    private int lowerBound=1;
    private Scanner input = new Scanner(System.in);
    /*public CardDealer(){
       
    }
    */
    public void askingDealer(){
         //Dealer wants to know how many cards and groups are being displayed.
         System.out.println("Please tell me how many cards you want to be played");
         totalNumOfCards = input.nextInt();
         System.out.println("Tell me how many groups you want");
         numOfGroups = input.nextInt();
         createCardDeck(totalNumOfCards, numOfGroups);
    }

    //Creating Deck 
    //BEGINING 
    public void createCardDeck(int totalNumOfCards , int numOfGroups){
        //Every group has at least 2 cards, so i subtract them from totalNumOfCards
        //For instance, if i have 40 cards and 4 groups, then remainingCards = 40 -2 * 4
        //I have placed groupSize of CardGroup's Constructor to be 2 by default
        this.groupSize = numOfGroups;
         remainingCards = totalNumOfCards - 2 * numOfGroups;
         int max;
        //System.out.println("Malakas");
        //If remaining cards are 0, that means that i have groups with exactly 2 cards.
        if(remainingCards == 0){
            for(int i=0; i<numOfGroups; i++){
                //System.out.println("Kourampies");
                //MaxCardsToRemove are between 1-2
                groups.add(new CardGroup(0, lowerBound));
                //Groups.add(new CardGroup(0).getCardsGroup());
            }
        }
        //If totalNumOfCards/numOfGroups < 2 -> Groups are too many
        else if(totalNumOfCards/numOfGroups < 2){
            System.out.println("Groups are too many");
            askingDealer();
        }
        //(Example. If i have 21/10, then 21/10=2 but i have one remaining or if i have 12/4 > 2) ---> that means
        //that i will add cards to the default cardGroup creation.
        else if(totalNumOfCards/numOfGroups == 2 && totalNumOfCards % numOfGroups !=0 || totalNumOfCards/numOfGroups > 2 ){
            int cardsForGroup;
            for(int i=0; i<numOfGroups; i++){
                if(i==numOfGroups - 1){
                    //If i go to the last group, then the cards of Group will be the remaining
                    cardsForGroup = remainingCards;
                }
                else{
                    //Here, i choose a number between 0 - remainingCards
                    cardsForGroup =  (int)(Math.random() * remainingCards) + 0;
                    //cardsForGroup = random.nextInt(remainingCards - lowerBound + 1) + lowerBound; 
                    remainingCards -= cardsForGroup;
                }

                if (remainingCards==0){
                    groups.add(new CardGroup(0,lowerBound));
                }
                else{
                    max =  (int)(Math.random() * cardsForGroup) + lowerBound;
                    groups.add(new CardGroup(cardsForGroup, max));
                }
                
            }
        
        }
        Collections.shuffle(groups);
    }
    //END
    public void humanMove(){
        System.out.println("From which group would you like to remove cards?");
        int group = input.nextInt();
        System.out.println("How many cards would you like to remove?");
        int numOfCards = input.nextInt();
        removeCards(group, numOfCards);

    }
    public void botMove(int group, int numOfCards){
        System.out.print("Group chosen:" +group);
        System.out.print("Number of cards chosen: " +numOfCards);
        removeCards(group,numOfCards);
    }
    //Removing cards
    public void removeCards(int group, int numOfCards){
        groups.get(group).removeCards(numOfCards);
        readingArrayList();
        //I suppose bot doesnt make any mistake
        if( groups.get(group).removeCards(numOfCards) == false){
            humanMove();
        }

    }
    public int getNumOfCards() {
        return this.totalNumOfCards;
    }

    public void setNumOfCards(int numOfCards) {
        this.totalNumOfCards = numOfCards;
    }

    public int getNumOfGroups() {
        return this.numOfGroups;
    }

    public void setNumOfGroups(int numOfGroups) {
        this.numOfGroups = numOfGroups;
    }
    
    public int getGroupSize(){
        return this.groupSize;
    }

    public void readingArrayList(){
        for(int i=0; i<groupSize; i++){
            System.out.print("Group " +i);
            System.out.print(": ");
            System.out.print(groups.get(i).getCardsGroup());
            System.out.print("  Max cards to remove ---> " +groups.get(i).getMaxCardsToRemove());
            System.out.println();
        }
    }
    //main
    public static void main(String[] args){
        CardDealer cardDealer = new CardDealer();
        cardDealer.askingDealer();
        cardDealer.readingArrayList();
        cardDealer.humanMove();

    }
}
    
    

