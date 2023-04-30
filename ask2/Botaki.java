import java.util.ArrayList;
import java.util.List;

public class Botaki extends Player {

    private int groupToPlay;
    private int cardsToRemove;
    private int difficulty;
    
    public Botaki(String name ) {
        super(name);
    }

    
    public void calculateBestMove(CardDeck currentDeck , int level){
        System.out.println("Calculating best move...");
        Node tree = new Node(currentDeck);
        createTree(tree);
        tree.printTree();
        findBestMoveWithMinimax(tree);
        tree.printTree();
        Node nextMove  = new Node(level, level, currentDeck);
        for(Node child : tree.getChildren()){
            if(child.getValue() == tree.getValue()){
                nextMove = child;
                break;
            }
        }
        System.out.println("Best move is: " + nextMove.getCardsToRemove() + " " + nextMove.getGroup() + " " + nextMove.getValue());
    }

    private void findBestMoveWithMinimax(Node tree) {
        //randomly choose a move

        
        

        
        // //pick a random child node
        // int randomChild = (int) (Math.random() * tree.getChildren().size());
        // Node child = tree.getChildren().get(randomChild);

        
        
        List<Integer> values = new ArrayList<Integer>();
        for(Node child : tree.getChildren()){
            if(!child.getChildren().isEmpty()) findBestMoveWithMinimax(child);
            values.add(child.getValue());
        }
        
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

    public int getDifficulty() {
        return this.difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }


    public static void main(String[] args) {
        Botaki botaki = new Botaki("AI");
        CardDealer dealer = new CardDealer();
        int maxLevel = 3;
        dealer.requestCardDeck();
        dealer.printCardDeck();
        botaki.calculateBestMove(dealer.cardDeck , maxLevel);
    }




}
