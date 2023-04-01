


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
public class CardDealer {
    //Total number of Cards that arent in group. Dealer just shares the cards to groups
    private int totalNumOfCards;
    private int numOfGroups;
    private List<CardGroup> groups = new ArrayList<CardGroup>();
    //Creating a list that holds each size of Group
    List<Integer> Groups = new ArrayList<>();
    //Here i declare a randomIndex from Groups's list
    private int randomIndex;
    private int groupSize=0;
    private int remainingCards;
    Random randomGroups = new Random();

    /*public CardDealer(){
       
    }
    */
    public void askingDealer(){
         //Dealer wants to know how many cards and groups are being displayed.
         System.out.println("Please tell me how many cards you want to be played");
         Scanner input = new Scanner(System.in);
         totalNumOfCards = input.nextInt();
         System.out.println("Tell me how many groups you want");
         numOfGroups = input.nextInt();
         createCardDeck(totalNumOfCards, numOfGroups);
    }


    public void createCardDeck(int totalNumOfCards , int numOfGroups){
        //Every group has at least 2 cards, so i subtract them from totalNumOfCards
        //For instance, if i have 40 cards and 4 groups, then remainingCards = 40 -2 * 4
        //I have placed groupSize of CardGroup's Constructor to be 2 by default
        this.groupSize = numOfGroups;
         remainingCards = totalNumOfCards - 2 * numOfGroups;
        //System.out.println("Malakas");
        Random random = new Random();
        //If remaining cards are 0, that means that i have groups with exactly 2 cards.
        if(remainingCards == 0){
            for(int i=0; i<numOfGroups; i++){
                //System.out.println("Kourampies");
                groups.add(new CardGroup(0));
                Groups.add(new CardGroup(0).getCardsGroup());
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
                    //System.out.println("Malakas 2");
                    //Here, i choose a number between 0 - remainingCards
                    cardsForGroup = random.nextInt(remainingCards);
                    remainingCards -= cardsForGroup;
                }
                //edo ta kano add stin lista ton stoivadon. To 1o stoixeio tha einai i proti
                //stoivada me ta tade xaraktiristika.
                //Here i add them to the list of stacks. The first element is the first stack
                //with these specific characteristics.
                if (remainingCards==0){
                    //System.out.println("Lene pos eimai trelos");
                    groups.add(new CardGroup(remainingCards));
                    //Here i add them to the list of Groups that are Integers
                    Groups.add(new CardGroup(remainingCards).getCardsGroup());
                }
                else{
                    //System.out.println("Helllo there");
                    groups.add(new CardGroup(cardsForGroup));
                    //Here i add them to the list of Groups that are Integers
                    Groups.add(new CardGroup(cardsForGroup).getCardsGroup());
                }
                
            }
        
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

    /*public List getCardDeck() {
        return this.cardDeck;
    }

    public void setCardDeck(List cardDeck) {
        this.cardDeck = cardDeck;
    }
    */
    public void readingArrayList(){
        for(int i=0; i<groupSize; i++){
            //dimiourgo ena randomIndex gia na grabbaro ena
            randomIndex = randomGroups.nextInt(Groups.size());

            /*System.out.print("Group " +i);
            System.out.print(": ");
            System.out.print();
             */
            System.out.print("Group " +i);
            System.out.print(": ");
            System.out.print(Groups.get(randomIndex));
            System.out.println();
 
            // add element in temporary list
            //newList.add(list.get(randomIndex));
 
            // Remove selected element from original list
            Groups.remove(randomIndex);

        }
    }
}
    
    

