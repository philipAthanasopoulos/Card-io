import java.util.ArrayList;
import java.util.List;

public class Node {
    private int cardsToRemove;
    private int group;
    private CardDeck cardDeck;
    private List<Node> children = new ArrayList<Node>();
    private int nodeLevel;
    

    public Node(int cardsToRemove) {
        this.cardsToRemove = cardsToRemove;
    }

    public Node(CardDeck cardDeck) {
        this.cardDeck = new CardDeck(cardDeck);
    }

    public Node(int cardsToRemove, int group) {
        this.cardsToRemove = cardsToRemove;
        this.group = group;
    }

    public Node(int cardsToRemove, int group , CardDeck cardDeck) {
        this.cardsToRemove = cardsToRemove;
        this.group = group;
        this.cardDeck = new CardDeck(cardDeck);
    }

    public void addChild(Node child) {
        children.add(child);
    }

    public  void printTree() {
        printTreeHelper( "" ,true);
    }
    
    public  void printTreeHelper( String prefix, boolean isTail) {
        System.out.println(prefix + (isTail ? "└── " : "├── ") + this.cardsToRemove);
        for (int i = 0; i < this.children.size() - 1; i++) {
            Node child = this.children.get(i);
            child.printTreeHelper( prefix + (isTail ? "    " : "│   "), false);
        }
        if (this.children.size() > 0) {
            Node child = this.children.get(this.children.size() - 1);
            child.printTreeHelper( prefix + (isTail ? "    " : "│   "), true);
        }
    }

    public void createChildren(int level){
        this.cardDeck.removeCards(this.getCardsToRemove(), this.getGroup());
        if(this.getCardDeck().getNumOfCards() == 0){
            return;
        }
        if ( level == 0){
            return;
        }
        for(CardGroup group : cardDeck.getCardGroups()){
            if(group.getNumOfCards() == 0) continue;
            for(int cardsToRemove = 1 ; cardsToRemove <= group.getMaxCardsToRemove() ; cardsToRemove++){
                Node child = new Node(cardsToRemove, group.getGroupNumber() , cardDeck);
                addChild(child); 
                child.createChildren(level -1 ); 
            }       
        }
    }

    public int getCardsToRemove() {
        return this.cardsToRemove;
    }

    public void setCardsToRemove(int cardsToRemove) {
        this.cardsToRemove = cardsToRemove;
    }

    public int getGroup() {
        return this.group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public CardDeck getCardDeck() {
        return this.cardDeck;
    }

    public void setCardDeck(CardDeck cardDeck) {
        this.cardDeck = cardDeck;
    }

    public Node getChild(int index) {
        return this.children.get(index);
    }

    public List<Node> getChildren() {
        return this.children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public int getNodeLevel() {
        return this.nodeLevel;
    }

    public void setNodeLevel(int nodeLevel) {
        this.nodeLevel = nodeLevel;
    }


    public static void main(String[] args) {
        CardDealer dealer = new CardDealer();
        dealer.requestCardDeck();
        dealer.printCardDeck();
        Node tree = new Node(0 ,0 ,new CardDeck(dealer.cardDeck));
        tree.createChildren(20);
        tree.printTree();

    }

}
