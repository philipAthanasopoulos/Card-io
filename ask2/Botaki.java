

public class Botaki extends Player {

    private int groupToPlay;
    private int cardsToRemove;
    
    public Botaki(String name) {
        super(name);
    }

    
    public void calculateBestMove(CardDeck currentDeck){
        Node tree = new Node(currentDeck);
        createTree(tree);
        tree.printTree(tree);
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
