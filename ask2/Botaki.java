

public class Botaki extends Player {

    private int groupToPlay;
    private int cardsToRemove;
    
    public Botaki(String name) {
        super(name);
    }

    
    public void calculateBestMove(CardDeck currentDeck){
        Tree root = new Tree(0);
        Tree tree = createTree(currentDeck , root);
        tree.printTree2(tree);
    }

    public Tree createTree(CardDeck cardDeck , Tree root){
        if(cardDeck.cardGroups.size() == 0) return root;
        cardDeck.cardGroups.get(root.getGroup()).removeCards(root.getCardsToRemove() );
        
        
        for(CardGroup group : cardDeck.cardGroups){
            if(group.getNumOfCards() == 0 ) continue;
            int numOfCardsToRemove = 1;
            while(group.getMaxCardsToRemove() >= numOfCardsToRemove) {
                Tree child = new Tree(numOfCardsToRemove, group.getGroupNumber());
                root.children.add(child);
                numOfCardsToRemove++;
            }
            for(Tree child: root.children){
                CardDeck newCardDeck = cardDeck;
                createTree(newCardDeck , child);
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
