import java.util.ArrayList;
import java.util.List;

public class Botaki extends Player {

    private int groupToPlay;
    private int cardsToRemove;
    
    
    public Botaki(String name ) {
        super(name);
    }

    
    public void executeBestMove(CardDeck currentDeck){
        System.out.println("Calculating best move...");
        Node tree = new Node(currentDeck);
        createTree(tree);
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
            if(!child.getChildren().isEmpty())  findBestMoveWithMinimax(child);
            
            values.add(child.getValue());
        }
        if(tree.isMaximizingPlayer()) tree.setValue(getMaxValue(values));
        else tree.setValue(getMinValue(values));
    }


    private int getMinValue(List<Integer> values) {
        int res = 10000;
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
        botaki.executeBestMove(dealer.cardDeck);
    }




}
