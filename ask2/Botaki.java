import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Botaki extends Player {

    private int groupToPlay;
    private int cardsToRemove;
    
    public Botaki(String name) {
        super(name);
    }

    
    public void calculateBestMove(CardDeck currentDeck){
        System.out.println("Calculating best move...");
        Node tree = new Node(currentDeck);
        createTree(tree);
        findBestMoveWithMinimax(tree);
        // tree.printTree(tree);
    }

    private void findBestMoveWithMinimax(Node tree) {
        //randomly choose a move
        Random random = new Random();
        //pick a random child node
        Collections.shuffle(tree.getChildren());
        Node child = tree.getChildren().get(0);
        setCardsToRemove(child.getCardsToRemove());
        setGroupToPlay(child.getGroup());

        

    }


    public void createTree( Node node){
        node.createChildren();    
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
