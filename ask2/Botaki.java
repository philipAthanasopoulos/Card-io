
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.Caret;

public class Botaki extends Player {
    public Botaki(String name) {
        super(name);
    }

    private int groupToPlay;
    private int cardsToRemove;

    
    public void calculateBestMove(CardDeck currentDeck){
        Tree root = new Tree(0);
        Tree tree = createTree(currentDeck , root);
        tree.printTree(tree);
        
    }

    public Tree createTree(CardDeck cardDeck , Tree root){
        for(CardGroup group : cardDeck.cardGroups){
            for(int numOfCardsToRemove = 1 ; numOfCardsToRemove < (group.getMaxCardsToRemove() + 1) ; numOfCardsToRemove++){
                Tree child = new Tree(numOfCardsToRemove);
                child.data = numOfCardsToRemove;
                child.group = cardDeck.cardGroups.indexOf(group);
                root.children.add(child);
                // copyOfcardDeck.cardGroups.get(cardDeck.cardGroups.indexOf(group)).removeCards(numOfCardsToRemove);
                // createTree(copyOfcardDeck , child);
            }
        }

        for(Tree child : root.children){
            CardDeck copyOfcardDeck = cardDeck;
            copyOfcardDeck.cardGroups.get(child.group).removeCards(child.data); 
            createTree(cardDeck, child); 
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
