

import java.util.List;

public class CardGroup {
    //private int groupSize;
    private int cardsGroup=2;
    private int maxCardsToRemove;
    
    public CardGroup(int addedGroupSize, int maxCardsToRemove){
        this.cardsGroup += addedGroupSize;
        this.maxCardsToRemove = maxCardsToRemove;
    }

    public boolean removeCards(int cardsToRemove){
        if(cardsToRemove > cardsGroup) {
            System.out.println("You have chosen too many cards for removal. Choose something smaller");
            return false;
        }
        if(cardsToRemove > maxCardsToRemove){
            System.out.println("You have chosen too many cards for removal. Choose something smaller");
            return false;
        } 
        else {
            cardsGroup -= cardsToRemove;
            return true;
        }
    }


    public int getCardsGroup() {
        return this.cardsGroup;
    }

    public void setCardsGroup(int cardsGroup) {
        this.cardsGroup = cardsGroup;
    }


    public int getMaxCardsToRemove() {
        return this.maxCardsToRemove;
    }

    public void setMaxCardsToRemove(int maxCardsToRemove) {
        this.maxCardsToRemove = maxCardsToRemove;
    }



}
