

public class Botaki extends Player {
    public Botaki(String name) {
        super(name);
    }

    private int groupToPlay;
    private int cardsToRemove;

    
    public void calculateBestMove(CardDeck currentDeck){
        
    }

    public int getGroupToPlay() {
        return this.groupToPlay;
    }

    public void setGroupToPlay(int groupToPlay) {
        this.groupToPlay = groupToPlay;
    }

    public int getCardsToRemove() {
        return this.cardsToRemove;
    }

    public void setCardsToRemove(int cardsToRemove) {
        this.cardsToRemove = cardsToRemove;
    }


}
