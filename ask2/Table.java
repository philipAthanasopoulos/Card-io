
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Table {
    private static Player player;
    private static CardDealer cardDealer;
    private static Botaki spasmenoBotaki;  
    private static Scanner input;
    private boolean whoPlayedLast; // true is for human false is for machine
    



    public Table(){

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
      if(whoPlayedLast) 




    }
    
    
  }

}
