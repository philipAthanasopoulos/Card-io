
public class CardGroup {
    private int numOfCards;
    private int maxCardsToRemove;

    public CardGroup(int numOfCards, int maxCardsToRemove){
        this.numOfCards = numOfCards;
        this.maxCardsToRemove = maxCardsToRemove;
    }

    public boolean removeCards(int cardsToRemove){
        if(numOfCards == 0){
            System.out.println("You cant subtract more cards from this group");
            return false;
        }
        if(cardsToRemove > numOfCards) {
            System.out.println("You have chosen too many cards for removal. Choose something smaller");
            return false;
        }
        if(cardsToRemove > maxCardsToRemove){
            System.out.println("You have chosen too many cards for removal. Choose something smaller");
            return false;
        }
        else {
            numOfCards -= cardsToRemove;
            System.out.println("Cards have been succesfully removed.");
            return true;
        }
    }


    public int getMaxCardsToRemove() {
        return this.maxCardsToRemove;
    }

    public void setMaxCardsToRemove(int maxCardsToRemove) {
        this.maxCardsToRemove = maxCardsToRemove;
    }

    public int getNumOfCards() {
        return this.numOfCards;
    }

    public void setNumOfCards(int numOfCards) {
        this.numOfCards = numOfCards;
    }

}
