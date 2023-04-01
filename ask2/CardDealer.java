


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
public class CardDealer {
    //Total number of Cards that arent in group. Dealer just shares the cards to groups
    private int totalNumOfCards;
    private int numOfGroups;
    private List<CardGroup> groups = new ArrayList<CardGroup>();
    private int randomIndex;
    private int groupSize=0;
    private int remainingCards;
    List<Integer> Groups = new ArrayList<>();
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
        //Px, an exo 40 cards kai 4 groups, tote remainingCards = 40 -2*4
        //Exo valei ston Constructor tou CardGroup to groupSize apo default na einai 2
        this.groupSize = numOfGroups;
         remainingCards = totalNumOfCards - 2 * numOfGroups;
        //System.out.println("Malakas");
        Random random = new Random();
        if(remainingCards == 0){
            for(int i=0; i<numOfGroups; i++){
                //System.out.println("Kourampies");
                groups.add(new CardGroup(0));
                Groups.add(new CardGroup(0).getCardsGroup());
            }
        }
        else if(totalNumOfCards/numOfGroups < 2){
            System.out.println("Groups are too many");
            askingDealer();
        }
        else if(totalNumOfCards/numOfGroups == 2 && totalNumOfCards % numOfGroups !=0 || totalNumOfCards/numOfGroups > 2 ){
            int cardsForGroup;
            for(int i=0; i<numOfGroups; i++){
                if(i==numOfGroups - 1){
                    //Ean vretho sto teleutaio group tote ta cards tou Group tha einai ta remaining
                    cardsForGroup = remainingCards;
                }
                else{
                    //System.out.println("Malakas 2");
                    //Edo epilego enan arithmo apo 0-remainingCards
                    cardsForGroup = random.nextInt(remainingCards);
                    remainingCards -= cardsForGroup;
                }
                //edo ta kano add stin lista ton stoivadon. To 1o stoixeio tha einai i proti
                //stoivada me ta tade xaraktiristika.
                if (remainingCards==0){
                    //System.out.println("Lene pos eimai trelos");
                    groups.add(new CardGroup(remainingCards));
                    Groups.add(new CardGroup(remainingCards).getCardsGroup());
                }
                else{
                    //System.out.println("Helllo there");
                    groups.add(new CardGroup(cardsForGroup));
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
    
    

