package ask2;

import java.util.ArrayList;
import java.util.List;

public class CardDealer {
    private int numOfCards;
    private int numOfGroups;
    private List cardDeck;
    

    public CardDealer(){
        this.cardDeck = new ArrayList<>();
    }

    public void createCardDeck(int numOfCards , int numOfGroups){
        
    }

    public int getNumOfCards() {
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

    public List getCardDeck() {
        return this.cardDeck;
    }

    public void setCardDeck(List cardDeck) {
        this.cardDeck = cardDeck;
    }
    
}
