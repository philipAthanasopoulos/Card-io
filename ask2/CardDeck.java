

import java.util.ArrayList;
import java.util.List;

public class CardDeck {
    private int numOfCards;
    private List<CardGroup> cardGroups;

    public CardDeck(int numOfCards , int numOfGroups){
        this.numOfCards = numOfCards;
        this.cardGroups = new ArrayList<CardGroup>();
    }


}
