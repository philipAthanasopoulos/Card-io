
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthStyle;

public class Table {
    private static Player player;
    private static CardDealer cardDealer;
    private static Botaki spasmenoBotaki;  
    private static Scanner input;
    private static boolean whoPlayedLast; // true is for human false is for machine
    private static String winner;
    private static CardDeck cardDeck;
    

    public static void printStartScreen(){
      System.out.println(" ######     ###    ########  ########          ####  #######  ");
      System.out.println("##    ##   ## ##   ##     ## ##     ##          ##  ##     ## ");
      System.out.println("##        ##   ##  ##     ## ##     ##          ##  ##     ##");
      System.out.println("##       ##     ## ########  ##     ## #######  ##  ##     ## ");
      System.out.println("##       ######### ##   ##   ##     ##          ##  ##     ## ");
      System.out.println("##    ## ##     ## ##    ##  ##     ##          ##  ##     ## ");
      System.out.println(" ######  ##     ## ##     ## ########          ####  ####### \n ");
      

    }


    public  static void calculateWinner(){
      winner = whoPlayedLast ? player.getName() : spasmenoBotaki.getName();
    }
  
    
  public static void main(String[] args) {

    //init players and keyboard
    input = new Scanner(System.in);
    printStartScreen();
    System.out.println("Please enter your name : ");
    player = new Player(input.next());
    cardDealer = new CardDealer();
    spasmenoBotaki = new Botaki("AI");

    //-------------------HERE THE GAME BEGINS----------------------------------------------------
    
    cardDealer.askingDealer();
    cardDealer.readingArrayList();

    while(cardDealer.getNumOfCards() > 0){
      //cardDealer.readingArrayList();

      if(whoPlayedLast) {
        //spasmenoBotaki.calculateBestMove(cardDealer.getCardDeck());
        //cardDealer.botMove(spasmenoBotaki.getGroupToPlay() , spasmenoBotaki.getCardsToRemove());
        whoPlayedLast = false;
      }
      
      
      else{
        //System.out.println("Choose a group and the number of cards to remove");
        //int group = input.nextInt();
        //int numOfCards = input.nextInt();
        //cardDealer.removeCards(group , numOfCards);
        cardDealer.humanMove();
        //cardDealer.botMove(spasmenoBotaki.getGroupToPlay(), spasmenoBotaki.getCardsToRemove());
        whoPlayedLast = true;
      }
      System.out.println("Total cards in the game: " +cardDealer.getNumOfCards());
    }
    calculateWinner();
    System.out.println(winner + " has won the game");
    
    
  }

}
