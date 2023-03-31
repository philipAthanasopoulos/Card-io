package ask2;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
public class CardDealer {
    //Total number of Cards that arent in group. Dealer just shares the cards to groups
    private int totalNumOfCards;
    private int numOfGroups;
    private List<CardGroup> groups = new ArrayList<CardGroup>();
    private int randomNumber;


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
        int remainingCards = totalNumOfCards - 2 * numOfGroups;
        Random random = new Random();
        for(int i=0; i<numOfGroups; i++){
            int cardsForGroup;
            if(i==numOfGroups-1){
                //Ean vretho sto teleutaio group tote ta cards tou Group tha einai ta remaining
                cardsForGroup = remainingCards;
            }
            else{
                //Edo epilego enan arithmo apo 0-remainingCards
                cardsForGroup = random.nextInt(remainingCards);
                remainingCards -= cardsForGroup;
            }
            //edo ta kano add stin lista ton stoivadon. To 1o stoixeio tha einai i proti
            //stoivada me ta tade xaraktiristika.
            groups.add(new CardGroup(cardsForGroup));
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

    /*public List getCardDeck() {
        return this.cardDeck;
    }

    public void setCardDeck(List cardDeck) {
        this.cardDeck = cardDeck;
    }
    */
    
}
