import java.util.ArrayList;
import java.util.List;

public class Node {
    private int cardsToRemove;
    private int group;
    private CardDeck cardDeck;
    private List<Node> children = new ArrayList<Node>() ;

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

    
    public static void printTree(Node root) {
        printTreeHelper(root, "" ,true);
    }
    
    public static void printTreeHelper(Node node, String prefix, boolean isTail) {
        System.out.println(prefix + (isTail ? "└── " : "├── ") + node.cardsToRemove);
        for (int i = 0; i < node.children.size() - 1; i++) {
            Node child = node.children.get(i);
            printTreeHelper(child, prefix + (isTail ? "    " : "│   "), false);
        }
        if (node.children.size() > 0) {
            Node child = node.children.get(node.children.size() - 1);
            printTreeHelper(child, prefix + (isTail ? "    " : "│   "), true);
        }
    }

   


    public void createChildren(){
        this.cardDeck.removeCards(this.getCardsToRemove(), this.getGroup());
        if(this.getCardDeck().getNumOfCards() == 0){
            System.out.println("No more cards to remove");
            return;
        }

        System.out.println("Creating children for " + this.getCardsToRemove() + " " + this.getGroup());
        
        
        for(CardGroup group : cardDeck.cardGroups){
            if(group.getNumOfCards() == 0) continue;
            for(int cardsToRemove = 1 ; cardsToRemove <= group.getMaxCardsToRemove() ; cardsToRemove++){
                Node child = new Node(cardsToRemove, group.getGroupNumber() , cardDeck);
                addChild(child); 
                child.createChildren(); 
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



    public static void main(String[] args) {
        


        CardDealer dealer = new CardDealer();
        dealer.requestCardDeck();
        dealer.printCardDeck();
        Node tree = new Node(0 ,0 ,new CardDeck(dealer.cardDeck));
        tree.createChildren();
        tree.printTree(tree);

    }

}
