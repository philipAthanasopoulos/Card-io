

import java.util.ArrayList;
import java.util.List;

public class CardDeck{
    private int numOfCards;
    private int numOfGroups;
    List<CardGroup> cardGroups;

    public CardDeck(int numOfCards , int numOfGroups){
        this.numOfCards = numOfCards;
        this.cardGroups = new ArrayList<CardGroup>();
        for(int i = 0 ; i < numOfGroups ; i++){
            cardGroups.add(new CardGroup(0, 0));
        }
        
        this.numOfGroups = numOfGroups;
    }

    public CardDeck(CardDeck another){
        this(another.getNumOfCards(), another.getNumOfGroups() , new ArrayList<CardGroup>(another.getCardGroups()));
    }


   

    public CardDeck(int numOfCards2, int numOfGroups2, ArrayList<CardGroup> arrayList) {
        this.numOfCards = numOfCards2;
        this.numOfGroups = numOfGroups2;
        this.cardGroups = arrayList;
    }

    

   

    
    
    public int getNumOfCards() {
        int sum = 0;
        for(CardGroup group : cardGroups){
            sum += group.getNumOfCards();
        }
        setNumOfCards(sum);
        return this.numOfCards;
    }

    public void setNumOfCards(int numOfCards) {
        this.numOfCards = numOfCards;
    }
    

    private int getNumOfGroups() {
        return 0;
    }


    public void setNumOfGroups(int numOfGroups) {
        this.numOfGroups = numOfGroups;
    }

    public CardGroup getGroup(int groupNumber){
        return cardGroups.get(groupNumber);
    }


    public List<Node> getCardDeck() {
        return null;
    }


    private void setCardGroups(List<CardGroup> cardGroups) {
        this.cardGroups = cardGroups;
    }


    private List<CardGroup> getCardGroups() {
        return this.cardGroups;
    }

    public void removeCards(int cardsToRemove, int group) {
        this.cardGroups.get(group).removeCards(cardsToRemove);
    }


}
