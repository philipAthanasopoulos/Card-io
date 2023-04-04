
import java.util.Scanner;
public class Table {
    private static Player player;
    private static CardDealer cardDealer;
    private static Botaki spasmenoBotaki;  
    private static Scanner input;
    private static boolean whoPlayedLast; // true is for human false is for machine
    private static String winner;
    

    public static void printStartScreen(){

       final String ANSI_RESET = "\u001B[0m";
       final String ANSI_GREEN = "\033[0;32m";


      System.out.println(ANSI_GREEN + " ######     ###    ########  ########          ####  #######  ");
      System.out.println(           "##    ##   ## ##   ##     ## ##     ##          ##  ##     ## ");
      System.out.println(           "##        ##   ##  ##     ## ##     ##          ##  ##     ##");
      System.out.println(           "##       ##     ## ########  ##     ## #######  ##  ##     ## ");
      System.out.println(           "##       ######### ##   ##   ##     ##          ##  ##     ## ");
      System.out.println(           "##    ## ##     ## ##    ##  ##     ##          ##  ##     ## ");
      System.out.println(           " ######  ##     ## ##     ## ########          ####  ####### \n " +  ANSI_RESET);
      

    }


    public  static void calculateWinner(){
      winner = whoPlayedLast ? player.getName() : spasmenoBotaki.getName();
    }
  
    
  public static void main(String[] args) {

    //init players , dealer and keyboard
    input = new Scanner(System.in);
    printStartScreen();
    System.out.println("Please enter your name : ");
    player = new Player(input.next());
    cardDealer = new CardDealer();
    spasmenoBotaki = new Botaki("AI");

    //-------------------HERE THE GAME BEGINS----------------------------------------------------
    
    cardDealer.requestCardDeck();
    cardDealer.printCardDeck();

    // while(cardDealer.cardDeck.getNumOfCards() > 0){
    //   //cardDealer.readingArrayList();

    //   if(whoPlayedLast) {
    //     //spasmenoBotaki.calculateBestMove(cardDealer.getCardDeck());
    //     //cardDealer.botMove(spasmenoBotaki.getGroupToPlay() , spasmenoBotaki.getCardsToRemove());
    //     whoPlayedLast = false;
    //   }
      
      
    //   else{
    //     System.out.println("Choose a group and the number of cards to remove");
    //     int group = input.nextInt();
    //     int numOfCards = input.nextInt();
    //     cardDealer.removeCards(group , numOfCards);
    //     // cardDealer.humanMove();
    //     //cardDealer.botMove(spasmenoBotaki.getGroupToPlay(), spasmenoBotaki.getCardsToRemove());
    //     whoPlayedLast = true;
    //   }
    //   System.out.println("Total cards in the game: " +cardDealer.cardDeck.getNumOfCards());
    // }
    // calculateWinner();
    // System.out.println(winner + " has won the game");
    
    
  }

}
