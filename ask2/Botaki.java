
import java.util.ArrayList;
import java.util.List;

public class Botaki extends Player {
    public Botaki(String name) {
        super(name);
    }

    private int groupToPlay;
    private int cardsToRemove;

    
    public void calculateBestMove(CardDeck currentDeck){
        Tree tree = createTree(currentDeck);
        tree.printTree(tree);
        
    }

    public Tree createTree(CardDeck cardDeck){
        Tree root = new Tree(0);
        for(CardGroup group : cardDeck.cardGroups){
            for(int numOfCardsToRemove = 1 ; numOfCardsToRemove < group.getMaxCardsToRemove() ; numOfCardsToRemove++){
                root.children.add(new Tree(numOfCardsToRemove));
            }
        }
        return root;
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


    public static void main(String[] args) {
        Botaki botaki = new Botaki("AI");
        CardDealer dealer = new CardDealer();
        dealer.requestCardDeck();
        dealer.printCardDeck();
        botaki.calculateBestMove(dealer.cardDeck);
        

    }


}
