

import java.util.List;

public class CardGroup {
    //private int groupSize;
    private int cardsGroup=2;
    private int maxCardsToRemove;
    private int removalCards;
    private int numOfCards;

    public CardGroup(int numOfCards, int maxCardsToRemove){
        this.numOfCards = numOfCards;
        this.maxCardsToRemove = maxCardsToRemove;
    }

    public boolean removeCards(int cardsToRemove){
        if(this.cardsGroup==0){
            System.out.println("You cant subtract more cards from this group");
            return false;
        }
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
            this.removalCards = cardsToRemove;
            System.out.println("Cards have succesfully removed.");
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
    public int removalCards(){
        return this.removalCards;
    }

    public void setMaxCardsToRemove(int maxCardsToRemove) {
        this.maxCardsToRemove = maxCardsToRemove;
    }

    public int getRemovalCards() {
        return this.removalCards;
    }

    public void setRemovalCards(int removalCards) {
        this.removalCards = removalCards;
    }

    public int getNumOfCards() {
        return this.numOfCards;
    }

    public void setNumOfCards(int numOfCards) {
        this.numOfCards = numOfCards;
    }



}
