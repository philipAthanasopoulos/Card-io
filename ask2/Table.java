
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Table {
    private static Player player;
    private static CardDealer cardDealer;
    private static Botaki spasmenoBotaki;  
    private static Scanner input;
    private static boolean whoPlayedLast; // true is for human false is for machine
    private static String winner;
    



    public Table(){

    }

    public  static void calculateWinner(){
      if(whoPlayedLast) winner = player.getName();
      else winner = "AI";
    }
  
    
  public static void main(String[] args) {

    input = new Scanner(System.in);
    System.out.println("Please enter your name : ");
    player = new Player(input.next());
    cardDealer = new CardDealer();
    spasmenoBotaki = new Botaki();

   


    cardDealer.askingDealer();
    cardDealer.readingArrayList();

    while(cardDealer.getNumOfCards() > 0){
      cardDealer.readingArrayList();
      if(whoPlayedLast) {
        System.out.println("Choose a group and the number of cards to remove");
        int group = input.nextInt();
        int numOfCards = input.nextInt();
        cardDealer.removeCards(group , numOfCards);
      }
      //botaki code
      else{

      }




    }
    calculateWinner();
    System.out.println(winner + " has won the game");
    
    
  }

}
