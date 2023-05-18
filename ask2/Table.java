
import java.util.Scanner;

import javax.print.FlavorException;
import javax.xml.stream.events.Comment;
public class Table {
    private static Player player;
    private static CardDealer cardDealer;
    private static Botaki spasmenoBotaki;  
    private static Scanner input;
    private static boolean whoPlayedLast = true; // true is for human false is for machine
    private static String winner;
    final static String ANSI_RESET = "\u001B[0m";
    final static String ANSI_BRIGHT_GREEN = "\033[0;92m";
    final static String ANSI_YELLOW = "\033[33m";
    final static String ANSI_RED = "\033[31m";
    

    public static void printStartScreen(){


      System.out.println(ANSI_BRIGHT_GREEN);
      // System.out.println(" ######     ###    ########  ########          ####  #######  ");
      // System.out.println("##    ##   ## ##   ##     ## ##     ##          ##  ##     ## ");
      // System.out.println("##        ##   ##  ##     ## ##     ##          ##  ##     ##");
      // System.out.println("##       ##     ## ########  ##     ## #######  ##  ##     ## ");
      // System.out.println("##       ######### ##   ##   ##     ##          ##  ##     ## ");
      // System.out.println("##    ## ##     ## ##    ##  ##     ##          ##  ##     ## ");
      // System.out.println(" ######  ##     ## ##     ## ########          ####  ####### \n ");

      System.out.println(" ________  ________  ________  ________                             ___  ________ ");
      System.out.println("|\\   ____\\|\\   __  \\|\\   __  \\|\\   ___ \\                           |\\  \\|\\   __  \\    ");
      System.out.println("\\ \\  \\___|\\ \\  \\|\\  \\ \\  \\|\\  \\ \\  \\_|\\ \\        ____________      \\ \\  \\ \\  \\|\\  \\   ");
      System.out.println(" \\ \\  \\    \\ \\   __  \\ \\   _  _\\ \\  \\  \\ \\      |\\____________\\     \\ \\  \\ \\  \\ \\  \\  ");
      System.out.println("  \\ \\  \\____\\ \\  \\ \\  \\ \\  \\\\  \\\\ \\  \\_\\\\ \\     \\|____________|      \\ \\  \\ \\  \\ \\  \\ ");
      System.out.println("   \\ \\_______\\ \\__\\ \\__\\ \\__\\\\ _\\\\ \\_______\\                          \\ \\__\\ \\_______\\      ");
      System.out.println("    \\|_______|\\|__|\\|__|\\|__|\\|__|\\|_______|                           \\|__|\\|_______|");
   
   
      System.out.println(ANSI_RESET);
      

    }


    public  static void calculateWinner(){
      winner = whoPlayedLast ? player.getName() : spasmenoBotaki.getName();
    }
  
    
  public static void main(String[] args) {

    //init players , dealer and keyboard
    input = new Scanner(System.in);
    printStartScreen();
    player = new Player("PLAYER");
    spasmenoBotaki = new Botaki("AI");
    
    cardDealer = new CardDealer();

    //-------------------HERE THE GAME BEGINS----------------------------------------------------
    
    cardDealer.requestCardDeck();
    //ask player if he want to see the minimax tree
    System.out.println("Do you want to see the minimax tree? (y/n)");
    String answer = input.nextLine();
    if(answer.equals("y")) spasmenoBotaki.setShowTree(true);
    else spasmenoBotaki.setShowTree(false);

    
    while(cardDealer.checkCards()){
      cardDealer.printCardDeck();
      if(whoPlayedLast) cardDealer.askPlayersMove(spasmenoBotaki);
      else cardDealer.askPlayersMove(player);
      whoPlayedLast = whoPlayedLast ? false : true;
    }
    calculateWinner();
    System.out.println(ANSI_BRIGHT_GREEN + winner + " has won the game" + ANSI_RESET);
    
  }

}
