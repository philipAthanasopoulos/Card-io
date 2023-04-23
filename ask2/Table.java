
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
    System.out.println("Please choose AI difficulty : 1)Easy 2)Medium 3)Hard");
    spasmenoBotaki = new Botaki("AI" , input.nextInt());
    
    cardDealer = new CardDealer();

    //-------------------HERE THE GAME BEGINS----------------------------------------------------
    
    cardDealer.requestCardDeck();
    
    while(cardDealer.checkCards()){
      cardDealer.printCardDeck();
      if(whoPlayedLast) cardDealer.askPlayersMove(spasmenoBotaki);
      else cardDealer.askPlayersMove(player);
      whoPlayedLast = whoPlayedLast ? false : true;
    }
    calculateWinner();
    System.out.println(winner + " has won the game");
    
  }

}
