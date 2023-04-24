

public class Botaki extends Player {

    private int groupToPlay;
    private int cardsToRemove;
    private int difficulty;
    
    public Botaki(String name , int difficulty) {
        super(name);
        this.difficulty = difficulty;
    }

    
    public void calculateBestMove(CardDeck currentDeck , int level){
        System.out.println("Calculating best move...");
        Node tree = new Node(currentDeck);
        createTree(tree , level);
        findBestMoveWithMinimax(tree);
        tree.printTree();
    }

    private void findBestMoveWithMinimax(Node tree) {
        //randomly choose a move
        
        //pick a random child node
        int randomChild = (int) (Math.random() * tree.getChildren().size());
        Node child = tree.getChildren().get(randomChild);

        setCardsToRemove(child.getCardsToRemove());
        setGroupToPlay(child.getGroup());

        

    }


    public void createTree( Node node , int level){
        node.createChildren(level);
        
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
        Botaki botaki = new Botaki("AI" , 2);
        CardDealer dealer = new CardDealer();
        int maxLevel = 3;
        dealer.requestCardDeck();
        dealer.printCardDeck();
        botaki.calculateBestMove(dealer.cardDeck , maxLevel);
    }




}
