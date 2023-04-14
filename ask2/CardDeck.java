

import java.util.ArrayList;
import java.util.List;

public class CardDeck {
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

    public int getNumOfGroups() {
        return this.numOfGroups;
    }

    public void setNumOfGroups(int numOfGroups) {
        this.numOfGroups = numOfGroups;
    }

    public CardGroup getGroup(int groupNumber){
        return cardGroups.get(groupNumber);
    }


}
