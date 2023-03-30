package ask2;

import java.util.List;

public class CardGroup {
    private int groupSize;
    private int maxCardsToRemove;


    public CardGroup(int groupSize , int maxCardsToRemove){
        this.groupSize = groupSize;
        this.maxCardsToRemove = maxCardsToRemove;
    }

    public boolean removeCards(int cardsToRemove){
        if(cardsToRemove > groupSize) return false;
        if(cardsToRemove > maxCardsToRemove) return false;
        else {
            groupSize -= cardsToRemove;
            return true;
        }
    }

    public int getGroupSize() {
        return this.groupSize;
    }

    public void setGroupSize(int groupSize) {
        this.groupSize = groupSize;
    }

    public int getMaxCardsToRemove() {
        return this.maxCardsToRemove;
    }

    public void setMaxCardsToRemove(int maxCardsToRemove) {
        this.maxCardsToRemove = maxCardsToRemove;
    }



}
