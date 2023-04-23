

import java.util.ArrayList;
import java.util.List;


public class CardDeck{
    private int numOfCards;
    private int numOfGroups;
    private List<CardGroup> cardGroups;

    public CardDeck(int numOfCards , int numOfGroups){
        this.numOfCards = numOfCards;
        this.numOfGroups = numOfGroups;
        this.cardGroups = new ArrayList<CardGroup>();
        for(int i = 0 ; i < numOfGroups ; i++){
            cardGroups.add(new CardGroup(0, 0));
        }
    }


    public CardDeck(CardDeck other){
        List<CardGroup> copiedGroups = new ArrayList<>();
        for (CardGroup group : other.getCardGroups()) {
            CardGroup copiedGroup = new CardGroup(group);
            copiedGroups.add(copiedGroup);
        }
        // Set the new list of CardGroup objects as the property of the new CardDeck object
        this.setCardGroups(copiedGroups);
    }


    public CardDeck(int numOfCards2, int numOfGroups2, ArrayList<CardGroup> arrayList) {
        this.numOfCards = numOfCards2;
        this.numOfGroups = numOfGroups2;
        this.cardGroups = arrayList;
    }


    public int getNumOfCards() {
        int sum = 0;
        for(CardGroup group : cardGroups) sum += group.getNumOfCards();
        setNumOfCards(sum);
        return this.numOfCards;
    }


    public void setNumOfCards(int numOfCards) {
        this.numOfCards = numOfCards;
    }
    

    private int getNumOfGroups() {
        return this.numOfGroups;
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


    public void setCardGroups(List<CardGroup> cardGroups) {
        this.cardGroups = cardGroups;
    }


    public List<CardGroup> getCardGroups() {
        return this.cardGroups;
    }

    public void removeCards(int cardsToRemove, int group) {
        for(CardGroup cardGroup : getCardGroups()){
            if(cardGroup.getGroupNumber() == group){
                cardGroup.removeCards(cardsToRemove);
                break;
            }
        }
    }

    public void addCards(int cardsToAdd, int group) {
        this.cardGroups.get(group).addCards(cardsToAdd);
    }


	public CardDeck copy() {
        ArrayList<CardGroup> copiedGroups = new ArrayList<>();
        for (CardGroup group : this.getCardGroups()) {
            CardGroup copiedGroup = new CardGroup(group);
            copiedGroups.add(copiedGroup);
        }
        // Set the new list of CardGroup objects as the property of the new CardDeck object
        return new CardDeck(this.getNumOfCards(), this.getNumOfGroups(), copiedGroups);
	}




}
