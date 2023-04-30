import java.util.ArrayList;
import java.util.List;

public class Botaki extends Player {

    private int groupToPlay;
    private int cardsToRemove;
    
    
    public Botaki(String name ) {
        super(name);
    }

    
    public void calculateBestMove(CardDeck currentDeck){
        System.out.println("Calculating best move...");
        Node tree = new Node(currentDeck);
        createTree(tree);
        tree.printTree();
        findBestMoveWithMinimax(tree);
        tree.printTree();
        Node nextMove  = new Node(currentDeck);
        for(Node child : tree.getChildren()){
            if(child.getValue() == tree.getValue()){
                nextMove = child;
                break;
            }
        }
        this.setCardsToRemove(nextMove.getCardsToRemove());
        this.setGroupToPlay(nextMove.getGroup());
        System.out.println("Best move is: " + nextMove.getCardsToRemove() + " " + nextMove.getGroup() + " " + nextMove.getValue());
    }

    private void findBestMoveWithMinimax(Node tree) {
        
        
        List<Integer> values = new ArrayList<Integer>();
        for(Node child : tree.getChildren()){
            if(child.getChildren().isEmpty()) values.add(child.getValue());
            else findBestMoveWithMinimax(child);
        }
        // System.out.println("Values are: " + values);
        if(tree.isMaximizingPlayer()) tree.setValue(getMaxValue(values));
        else tree.setValue(getMinValue(values));
        System.out.println(tree.isMaximizingPlayer() ? "Was looking for MAX" : "Was looking for MIN" );
        System.out.println("Best move is: " + tree.getCardsToRemove() + " " + tree.getGroup() + " " + tree.getValue());
    }


    private int getMinValue(List<Integer> values) {
        int res = Integer.MAX_VALUE;
        for(int number : values){
            if(number < res) res = number;
        }
        return res;
        
    }


    private int getMaxValue(List<Integer> values) {
        int res = Integer.MIN_VALUE;
        for(int number : values){
            if(number > res) res = number;
        }
        return res;
    }


    public void createTree( Node node){
        node.createChildren("MAX");
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
