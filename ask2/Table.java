
import java.util.Scanner;
public class Table {
    private static Player player;
    private static CardDealer cardDealer;
    private static Botaki spasmenoBotaki;  
    private static Scanner input;
    private static boolean whoPlayedLast; // true is for human false is for machine
    private static String winner;
    final static String ANSI_RESET = "\u001B[0m";
    final static String ANSI_GREEN = "\033[0;32m";
    final static String ANSI_YELLOW = "\033[33m";
    final static String ANSI_RED = "\033[31m";
    

    public static void printStartScreen(){


      System.out.println(ANSI_GREEN);
      System.out.println(" ######     ###    ########  ########          ####  #######  ");
      System.out.println("##    ##   ## ##   ##     ## ##     ##          ##  ##     ## ");
      System.out.println("##        ##   ##  ##     ## ##     ##          ##  ##     ##");
      System.out.println("##       ##     ## ########  ##     ## #######  ##  ##     ## ");
      System.out.println("##       ######### ##   ##   ##     ##          ##  ##     ## ");
      System.out.println("##    ## ##     ## ##    ##  ##     ##          ##  ##     ## ");
      System.out.println(" ######  ##     ## ##     ## ########          ####  ####### \n ");
      System.out.println(ANSI_RESET);
      

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
    System.out.println("Please choose AI difficulty :" + ANSI_GREEN+" 1)Easy"+ ANSI_YELLOW + " 2)Medium" +ANSI_RED+" 3)Hard" + ANSI_RESET);
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
